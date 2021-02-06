package cj.software.spring.experiments.aop.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@XmlType(name = "contract-summary", propOrder =
{ "id", "partner1", "partner2", "expirationDate"
})
public class ContractSummary
		implements
		Serializable,
		Comparable<ContractSummary>
{
	private static final long serialVersionUID = 1L;

	@NotNull
	private Long id;

	@NotBlank
	private String partner1;

	@NotBlank
	private String partner2;

	@NotNull
	private OffsetDateTime expirationDate;

	public ContractSummary(
			@NotNull Long id,
			@NotBlank String partner1,
			@NotBlank String partner2,
			@NotNull OffsetDateTime expirationDate)
	{
		super();
		this.id = id;
		this.partner1 = partner1;
		this.partner2 = partner2;
		this.expirationDate = expirationDate;
	}

	public Long getId()
	{
		return this.id;
	}

	public String getPartner1()
	{
		return this.partner1;
	}

	public String getPartner2()
	{
		return this.partner2;
	}

	public OffsetDateTime getExpirationDate()
	{
		return this.expirationDate;
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean result;
		if (obj instanceof ContractSummary)
		{
			ContractSummary other = (ContractSummary) obj;
			EqualsBuilder builder = new EqualsBuilder().append(this.id, other.id);
			result = builder.build();
		}
		else
		{
			result = false;
		}
		return result;
	}

	@Override
	public int hashCode()
	{
		HashCodeBuilder builder = new HashCodeBuilder().append(this.id);
		int result = builder.build();
		return result;
	}

	@Override
	public int compareTo(ContractSummary other)
	{
		CompareToBuilder builder = new CompareToBuilder().append(this.id, other.id);
		int result = builder.build();
		return result;
	}
}
