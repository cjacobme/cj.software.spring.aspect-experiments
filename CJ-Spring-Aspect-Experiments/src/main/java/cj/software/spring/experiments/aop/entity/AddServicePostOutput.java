package cj.software.spring.experiments.aop.entity;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "add-service-post-output")
@XmlType(name = "", propOrder =
{ "serviceId"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class AddServicePostOutput
{
	@NotNull
	@XmlElement(name = "service-id", required = true)
	private UUID serviceId;

	private AddServicePostOutput()
	{
	}

	public UUID getServiceId()
	{
		return this.serviceId;
	}

	private void setServiceId(UUID serviceId)
	{
		this.serviceId = serviceId;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	@XmlTransient
	public static class Builder
	{
		protected AddServicePostOutput instance;

		protected Builder()
		{
			this.instance = new AddServicePostOutput();
		}

		public Builder withServiceId(UUID serviceId)
		{
			this.instance.setServiceId(serviceId);
			return this;
		}

		public AddServicePostOutput build()
		{
			AddServicePostOutput result = this.instance;
			this.instance = null;
			return result;
		}
	}
}
