package cj.software.spring.experiments.aop.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "service-detail-get-output")
@XmlType(name = "", propOrder =
{ "service"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class ServiceDetailGetOutput
{
	@NotNull
	@Valid
	@XmlElement(name = "service", required = true)
	private Service service;

	private ServiceDetailGetOutput()
	{
	}

	public Service getService()
	{
		return this.service;
	}

	private void setService(Service service)
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
		protected ServiceDetailGetOutput instance;

		protected Builder()
		{
			this.instance = new ServiceDetailGetOutput();
		}

		public Builder withService(Service service)
		{
			this.instance.setService(service);
			return this;
		}

		public ServiceDetailGetOutput build()
		{
			ServiceDetailGetOutput result = this.instance;
			this.instance = null;
			return result;
		}
	}
}
