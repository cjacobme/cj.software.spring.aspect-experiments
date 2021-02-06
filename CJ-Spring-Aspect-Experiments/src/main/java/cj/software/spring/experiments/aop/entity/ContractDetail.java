package cj.software.spring.experiments.aop.entity;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.Period;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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

	ContractDetail()
	{
	}

	public ContractDetail(
			Long id,
			String partner1,
			String partner2,
			OffsetDateTime expiration,
			@NotNull OffsetDateTime signedTimestamp,
			@NotNull LocalDate deliveryStart,
			@NotNull LocalDate deliveryEnd,
			double deliveryAmount,
			double price,
			@NotNull Period billingPeriod)
	{
		super(id, partner1, partner2, expiration);
		this.signedTimestamp = signedTimestamp;
		this.deliveryStart = deliveryStart;
		this.deliveryEnd = deliveryEnd;
		this.deliveryAmount = deliveryAmount;
		this.price = price;
		this.billingPeriod = billingPeriod;
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
}
