package cj.software.spring.experiments.aop.jaxb;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OffsetDateTimeAdapter
		extends XmlAdapter<String, OffsetDateTime>
{
	@Override
	public OffsetDateTime unmarshal(String value) throws Exception
	{
		OffsetDateTime result;

		if (value != null)
		{
			result = OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
		else
		{
			result = null;
		}
		return result;
	}

	@Override
	public String marshal(OffsetDateTime value) throws Exception
	{
		String result;
		if (value != null)
		{
			result = value.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		}
		else
		{
			result = null;
		}
		return result;
	}

}
