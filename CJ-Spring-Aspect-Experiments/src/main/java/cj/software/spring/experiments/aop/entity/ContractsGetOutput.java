package cj.software.spring.experiments.aop.entity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "contracts-get-output")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder =
{ "entries"
})
public class ContractsGetOutput
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "contracts", required = true)
	@XmlElement(name = "summary")
	private List<ContractSummary> entries;

	ContractsGetOutput()
	{
	}

	public ContractsGetOutput(List<ContractSummary> entries)
	{
		super();
		this.entries = entries;
	}

	public List<ContractSummary> getEntries()
	{
		return this.entries;
	}

}
