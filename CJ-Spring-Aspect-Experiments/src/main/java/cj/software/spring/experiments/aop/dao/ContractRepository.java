package cj.software.spring.experiments.aop.dao;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.springframework.stereotype.Service;

import cj.software.spring.experiments.aop.entity.ContractDetail;
import cj.software.spring.experiments.aop.entity.ContractSummary;

@Service
public class ContractRepository
{

	private static Map<UUID, ContractDetail> details;

	private static List<ContractSummary> summaries;

	static
	{
		setDetails(createDetails());
		setSummaries(createSummaries());
	}

	private static void setDetails(Map<UUID, ContractDetail> details)
	{
		ContractRepository.details = details;
	}

	private static void setSummaries(List<ContractSummary> summaries)
	{
		ContractRepository.summaries = summaries;
	}

	private static List<ContractSummary> createSummaries()
	{
		List<ContractSummary> result = new ArrayList<>();
		for (UUID key : details.keySet())
		{
			ContractDetail detail = details.get(key);
			ContractSummary summary = toSummary(detail);
			result.add(summary);
		}
		Collections.sort(result, new Comparator<ContractSummary>()
		{

			@Override
			public int compare(ContractSummary o1, ContractSummary o2)
			{
				CompareToBuilder builder = new CompareToBuilder().append(o1.getId(), o2.getId());
				int result = builder.build();
				return result;
			}
		});
		return result;
	}

	private static ContractSummary toSummary(ContractDetail detail)
	{
		ContractSummary result = ContractSummary.builder()
				.withId(detail.getId())
				.withPartner1(detail.getPartner1())
				.withPartner2(detail.getPartner2())
				.withExpirationDate(detail.getExpirationDate())
				.build();
		return result;
	}

	private static Map<UUID, ContractDetail> createDetails()
	{
		Map<UUID, ContractDetail> result = new HashMap<>();
		ContractDetail detail1 = ContractDetail.builder()
				.withId(UUID.fromString("feaffeaf-cf7b-4543-8378-f92ce6670983"))
				.withPartner1("asdf")
				.withPartner2("qwer")
				.withExpirationDate(
						OffsetDateTime.of(2021, 6, 30, 23, 59, 59, 0, ZoneOffset.ofHours(2)))
				.withDeliveryStart(LocalDate.of(2021, 1, 1))
				.withDeliveryEnd(LocalDate.of(2021, 12, 31))
				.withSignedTimestamp(
						OffsetDateTime.of(2019, 4, 30, 23, 59, 59, 0, ZoneOffset.ofHours(2)))
				.withDeliveryAmount(30000.0)
				.withPrice(200.0)
				.withBillingPeriod(Period.ofMonths(1))
				.build();
		ContractDetail detail2 = ContractDetail.builder()
				.withId(UUID.fromString("6be7a8c1-047d-48b2-a6cd-246776533c35"))
				.withPartner1("BRV")
				.withPartner2("Sergej Grankin")
				.withExpirationDate(
						OffsetDateTime.of(2040, 12, 31, 23, 59, 59, 0, ZoneOffset.ofHours(1)))
				.withDeliveryStart(LocalDate.of(2019, 1, 1))
				.withDeliveryEnd(LocalDate.of(2039, 12, 31))
				.withSignedTimestamp(
						OffsetDateTime.of(2019, 4, 30, 23, 59, 59, 0, ZoneOffset.ofHours(2)))
				.withDeliveryAmount(40000.0)
				.withPrice(300.0)
				.withBillingPeriod(Period.ofMonths(3))
				.build();
		result.put(detail1.getId(), detail1);
		result.put(detail2.getId(), detail2);
		return result;
	}

	public List<ContractSummary> readContractSummaryList()
	{
		return summaries;
	}

	public ContractDetail getContractDetail(UUID id)
	{
		ContractDetail result = ContractRepository.details.get(id);
		return result;
	}
}
