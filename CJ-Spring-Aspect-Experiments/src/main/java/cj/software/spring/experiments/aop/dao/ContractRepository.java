package cj.software.spring.experiments.aop.dao;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import cj.software.spring.experiments.aop.entity.ContractDetail;
import cj.software.spring.experiments.aop.entity.ContractSummary;

@Service
public class ContractRepository
{
	private static Set<ContractSummary> summaries = fillSummaries();

	Map<Long, ContractDetail> details = fillDetails();

	private static Set<ContractSummary> fillSummaries()
	{
		Set<ContractSummary> result = new TreeSet<>();
		result.add(
				new ContractSummary(
						1l,
						"asdf",
						"qwer",
						OffsetDateTime.of(2021, 6, 30, 23, 59, 59, 0, ZoneOffset.ofHours(2))));
		result.add(
				new ContractSummary(
						2l,
						"BRV",
						"Sergej Grankin",
						OffsetDateTime.of(2040, 12, 31, 23, 59, 59, 0, ZoneOffset.ofHours(1))));
		return result;
	}

	private static Map<Long, ContractDetail> fillDetails()
	{
		Map<Long, ContractDetail> result = new HashMap<>();
		result.put(
				1l,
				new ContractDetail(
						1l,
						"asdf",
						"qwer",
						OffsetDateTime.of(2021, 6, 30, 23, 59, 59, 0, ZoneOffset.ofHours(2)),
						OffsetDateTime.of(2019, 4, 30, 23, 59, 59, 0, ZoneOffset.ofHours(2)),
						LocalDate.of(2021, 1, 1),
						LocalDate.of(2021, 12, 31),
						30000.0,
						200.0,
						Period.ofMonths(1)));
		result.put(
				2l,
				new ContractDetail(
						2l,
						"BRV",
						"Sergej Grankin",
						OffsetDateTime.of(2040, 12, 31, 23, 59, 59, 0, ZoneOffset.ofHours(1)),
						OffsetDateTime.of(2019, 4, 30, 23, 59, 59, 0, ZoneOffset.ofHours(2)),
						LocalDate.of(2019, 1, 1),
						LocalDate.of(2039, 12, 31),
						40000.0,
						300.0,
						Period.ofMonths(3)));
		return result;
	}

	public List<ContractSummary> readContractSummaryList()
	{
		return new ArrayList<>(summaries);
	}

	public ContractDetail getContractDetail(Long id)
	{
		ContractDetail result = this.details.get(id);
		return result;
	}
}
