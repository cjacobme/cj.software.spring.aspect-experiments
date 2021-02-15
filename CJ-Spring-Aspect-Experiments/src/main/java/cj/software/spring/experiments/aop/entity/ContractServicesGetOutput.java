package cj.software.spring.experiments.aop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "contract-services-get-output")
@XmlType(name = "", propOrder =
{ "serviceIds"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractServicesGetOutput
		implements
		Serializable
{
	private static final long serialVersionUID = 1L;

	@XmlElementWrapper(name = "service-ids", required = false)
	@XmlElement(name = "id")
	private List<UUID> serviceIds = new ArrayList<>();

	private ContractServicesGetOutput()
	{
	}

	public List<UUID> getServiceIds()
	{
		return this.serviceIds;
	}

	private void setServiceIds(List<UUID> serviceIds)
	{
		this.serviceIds.clear();
		if (serviceIds != null)
		{
			Collections.sort(serviceIds);
			this.serviceIds.addAll(serviceIds);
		}
	}

	public static Builder builder()
	{
		return new Builder();
	}

	@XmlTransient
	public static class Builder
	{
		protected ContractServicesGetOutput instance;

		protected Builder()
		{
			this.instance = new ContractServicesGetOutput();
		}

		public Builder withServiceId(UUID... uuids)
		{
			return this.withServiceIds(
					uuids != null ? Arrays.asList(uuids) : Collections.emptyList());
		}

		public Builder withServiceIds(Collection<UUID> uuids)
		{
			List<UUID> asList = (uuids != null ? new ArrayList<>(uuids) : Collections.emptyList());
			this.instance.setServiceIds(asList);
			return this;
		}

		public ContractServicesGetOutput build()
		{
			ContractServicesGetOutput result = this.instance;
			this.instance = null;
			return result;
		}
	}
}
