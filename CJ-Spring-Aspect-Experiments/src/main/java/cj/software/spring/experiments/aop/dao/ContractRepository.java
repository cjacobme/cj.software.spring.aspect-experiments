package cj.software.spring.experiments.aop.dao;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import cj.software.spring.experiments.aop.entity.ContractSummary;

@Service
public class ContractRepository
{
	private static Set<ContractSummary> summaries = fillSummaries();

	private static Set<ContractSummary> fillSummaries()
	{
		Set<ContractSummary> result = new TreeSet<>();
		result.addAll(
				Arrays.asList(
						new ContractSummary(
								1l,
								"asdf",
								"qwer",
								OffsetDateTime.of(
										2021,
										6,
										30,
										23,
										59,
										59,
										0,
										ZoneOffset.ofHours(2))),
						new ContractSummary(
								2l,
								"BRV",
								"Sergej Grankin",
								OffsetDateTime.of(
										2040,
										12,
										31,
										23,
										59,
										59,
										0,
										ZoneOffset.ofHours(1)))));
		return result;
	}

	public List<ContractSummary> readContractSummaryList()
	{
		return new ArrayList<>(summaries);
	}
}
