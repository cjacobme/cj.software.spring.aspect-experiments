package cj.software.spring.experiments.aop.entity;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cj.software.spring.experiments.aop.jaxb.OffsetDateTimeAdapter;

@XmlType(name = "service", propOrder =
{ "timestamp", "description", "fee"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Service
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@NotNull
	@XmlJavaTypeAdapter(value = OffsetDateTimeAdapter.class)
	@XmlElement(name = "timestamp", required = true)
	private OffsetDateTime timestamp;

	@NotBlank
	@XmlElement(name = "description", required = true)
	private String description;

	@XmlElement(name = "fee", required = true)
	private double fee;

	private Service()
	{
	}

	public OffsetDateTime getTimestamp()
	{
		return this.timestamp;
	}

	public String getDescription()
	{
		return this.description;
	}

	public double getFee()
	{
		return this.fee;
	}

	private void setTimestamp(OffsetDateTime timestamp)
	{
		this.timestamp = timestamp;
	}

	private void setDescription(String description)
	{
		this.description = description;
	}

	private void setFee(double fee)
	{
		this.fee = fee;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	@XmlTransient
	public static class Builder
	{
		protected Service instance;

		protected Builder()
		{
			this.instance = new Service();
		}

		public Builder withTimestamp(OffsetDateTime timestamp)
		{
			this.instance.setTimestamp(timestamp);
			return this;
		}

		public Builder withDescription(String description)
		{
			this.instance.setDescription(description);
			return this;
		}

		public Builder withFee(double fee)
		{
			this.instance.setFee(fee);
			return this;
		}

		public Service build()
		{
			Service result = this.instance;
			this.instance = null;
			return result;
		}
	}
}
