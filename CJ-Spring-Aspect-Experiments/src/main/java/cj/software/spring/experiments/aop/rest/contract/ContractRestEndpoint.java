package cj.software.spring.experiments.aop.rest.contract;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import cj.software.spring.experiments.aop.dao.ContractRepository;
import cj.software.spring.experiments.aop.entity.AddServicePostInput;
import cj.software.spring.experiments.aop.entity.ContractDetail;
import cj.software.spring.experiments.aop.entity.ContractGetOutput;
import cj.software.spring.experiments.aop.entity.ContractSummary;
import cj.software.spring.experiments.aop.entity.ContractsGetOutput;

@RestController
@RequestMapping(path = "/contracts", produces =
{ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE
})
public class ContractRestEndpoint
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
	public ContractGetOutput getContractDetail(@PathVariable(name = "id", required = true) UUID id)
	{
		this.logger.info("download contract details for %s...", id);
		ContractDetail contractDetail = this.contractRepository.getContractDetail(id);
		ContractGetOutput result = new ContractGetOutput(contractDetail);
		this.logger.info("return detail");
		return result;
	}

	@PostMapping(path = "{id}/add-service")
	@ResponseBody
	@Valid
	public ResponseEntity<Void> addService(
			@PathVariable(name = "id", required = true) UUID id,
			@RequestBody AddServicePostInput input,
			UriComponentsBuilder uriComponentsBuilder)
	{

		this.logger.info("add a new service...");
		ContractDetail contractDetail = this.contractRepository.getContractDetail(id);
		UUID serviceId = UUID.randomUUID();
		contractDetail.addService(serviceId, input.getService());
		this.logger.info("service saved with id %s", serviceId);
		UriComponents uriComponents = uriComponentsBuilder.path(
				"contracts/{contract-id}/services/{service-id}").buildAndExpand(id, serviceId);
		ResponseEntity<Void> result = ResponseEntity.created(uriComponents.toUri()).build();
		return result;
	}
}
