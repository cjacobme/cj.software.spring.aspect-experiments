package cj.software.spring.experiments.aop.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cj.software.spring.experiments.aop.dao.ContractRepository;
import cj.software.spring.experiments.aop.entity.ContractDetail;
import cj.software.spring.experiments.aop.entity.ContractGetOutput;
import cj.software.spring.experiments.aop.entity.ContractSummary;
import cj.software.spring.experiments.aop.entity.ContractsGetOutput;

@RestController
@RequestMapping(path = "/contracts", produces =
{ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE
})
public class RestEndpoint
{
	private Logger logger = LogManager.getFormatterLogger();

	@Autowired
	private ContractRepository contractRepository;

	@GetMapping
	public ContractsGetOutput getContracts()
	{
		this.logger.info("list contracts...");
		List<ContractSummary> summaries = this.contractRepository.readContractSummaryList();
		ContractsGetOutput result = new ContractsGetOutput(summaries);
		this.logger.info("return %d contract summaries", summaries.size());
		return result;
	}

	@GetMapping(path = "{id}")
	public ContractGetOutput getContractDetail(@PathVariable(name = "id", required = true) Long id)
	{
		this.logger.info("download contract details for %d...", id);
		ContractDetail contractDetail = this.contractRepository.getContractDetail(id);
		ContractGetOutput result = new ContractGetOutput(contractDetail);
		this.logger.info("return detail");
		return result;
	}
}
