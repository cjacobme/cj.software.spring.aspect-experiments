package cj.software.spring.experiments.aop.entity;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "contract-get-output")
@XmlType(name = "", propOrder =
{ "contract"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractGetOutput
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@NotNull
	@Valid
	@XmlElement(name = "contract", required = true)
	private ContractDetail contract;

	ContractGetOutput()
	{
	}

	public ContractGetOutput(ContractDetail contract)
	{
		this.contract = contract;
	}

	public ContractDetail getContract()
	{
		return this.contract;
	}
}
