package cj.software.spring.experiments.aop.entity;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "add-service-post-input")
@XmlType(name = "", propOrder =
{ "service"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class AddServicePostInput
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@NotNull
	@Valid
	@XmlElement(name = "service", required = true)
	private Service service;

	private AddServicePostInput()
	{
	}

	public Service getService()
	{
		return this.service;
	}

	public void setService(Service service)
	{
		this.service = service;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	@XmlTransient
	public static class Builder
	{
		protected AddServicePostInput instance;

		protected Builder()
		{
			this.instance = new AddServicePostInput();
		}

		public Builder withService(Service service)
		{
			this.instance.setService(service);
			return this;
		}

		public AddServicePostInput build()
		{
			AddServicePostInput result = this.instance;
			this.instance = null;
			return result;
		}
	}
}
