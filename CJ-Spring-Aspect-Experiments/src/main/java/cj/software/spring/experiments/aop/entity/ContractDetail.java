package cj.software.spring.experiments.aop.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cj.software.spring.experiments.aop.jaxb.LocalDateAdapter;
import cj.software.spring.experiments.aop.jaxb.OffsetDateTimeAdapter;

@XmlType(name = "contract-detail", propOrder =
{ "signedTimestamp", "deliveryStart", "deliveryEnd", "deliveryAmount", "price", "billingPeriod"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class ContractDetail
		extends ContractSummary
{
	private static final long serialVersionUID = 1L;

	@NotNull
	@XmlJavaTypeAdapter(value = OffsetDateTimeAdapter.class)
	@XmlElement(name = "signed-timestamp", required = true)
	private OffsetDateTime signedTimestamp;

	@NotNull
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	@XmlElement(name = "delivery-start", required = true)
	private LocalDate deliveryStart;

	@NotNull
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	@XmlElement(name = "delivery-end", required = true)
	private LocalDate deliveryEnd;

	@XmlElement(name = "delivery-amount", required = true)
	private double deliveryAmount;

	@XmlElement(name = "price", required = true)
	private double price;

	@NotNull
	@XmlElement(name = "billing-period", required = true)
	@XmlJavaTypeAdapter(value = PeriodAdapter.class)
	private Period billingPeriod;

	private ContractDetail()
	{
	}

	public OffsetDateTime getSignedTimestamp()
	{
		return this.signedTimestamp;
	}

	public LocalDate getDeliveryStart()
	{
		return this.deliveryStart;
	}

	public LocalDate getDeliveryEnd()
	{
		return this.deliveryEnd;
	}

	public double getDeliveryAmount()
	{
		return this.deliveryAmount;
	}

	public double getPrice()
	{
		return this.price;
	}

	public Period getBillingPeriod()
	{
		return this.billingPeriod;
	}

	private void setSignedTimestamp(OffsetDateTime signedTimestamp)
	{
		this.signedTimestamp = signedTimestamp;
	}

	private void setDeliveryStart(LocalDate deliveryStart)
	{
		this.deliveryStart = deliveryStart;
	}

	private void setDeliveryEnd(LocalDate deliveryEnd)
	{
		this.deliveryEnd = deliveryEnd;
	}

	private void setDeliveryAmount(double deliveryAmount)
	{
		this.deliveryAmount = deliveryAmount;
	}

	private void setPrice(double price)
	{
		this.price = price;
	}

	private void setBillingPeriod(Period billingPeriod)
	{
		this.billingPeriod = billingPeriod;
	}

	public static Builder builder()
	{
		return new Builder();
	}

	@XmlTransient
	public static class Builder
			extends ContractSummary.Builder
	{
		protected Builder()
		{
			super.instance = new ContractDetail();
		}

		@Override
		public Builder withId(UUID id)
		{
			super.withId(id);
			return this;
		}

		@Override
		public Builder withPartner1(String partner1)
		{
			super.withPartner1(partner1);
			return this;
		}

		@Override
		public Builder withPartner2(String partner2)
		{
			super.withPartner2(partner2);
			return this;
		}

		@Override
		public Builder withExpirationDate(OffsetDateTime expirationDate)
		{
			super.withExpirationDate(expirationDate);
			return this;
		}

		public Builder withBillingPeriod(Period billingPeriod)
		{
			((ContractDetail) this.instance).setBillingPeriod(billingPeriod);
			return this;
		}

		public Builder withDeliveryAmount(double deliveryAmount)
		{
			((ContractDetail) this.instance).setDeliveryAmount(deliveryAmount);
			return this;
		}

		public Builder withDeliveryStart(LocalDate deliveryStart)
		{
			((ContractDetail) this.instance).setDeliveryStart(deliveryStart);
			return this;
		}

		public Builder withDeliveryEnd(LocalDate deliveryEnd)
		{
			((ContractDetail) this.instance).setDeliveryEnd(deliveryEnd);
			return this;
		}

		public Builder withPrice(double price)
		{
			((ContractDetail) this.instance).setPrice(price);
			return this;
		}

		public Builder withSignedTimestamp(OffsetDateTime signedTimestamp)
		{
			((ContractDetail) this.instance).setSignedTimestamp(signedTimestamp);
			return this;
		}

		@Override
		public ContractDetail build()
		{
			ContractDetail result = (ContractDetail) this.instance;
			this.instance = null;
			return result;
		}
	}
}
