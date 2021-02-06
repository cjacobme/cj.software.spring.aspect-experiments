package cj.software.spring.experiments.aop.jaxb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter
		extends XmlAdapter<String, LocalDate>
{

	@Override
	public LocalDate unmarshal(String value) throws Exception
	{
		LocalDate result;
		if (value != null)
		{
			result = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
		}
		else
		{
			result = null;
		}
		return result;
	}

	@Override
	public String marshal(LocalDate value) throws Exception
	{
		String result;
		if (value != null)
		{
			result = value.format(DateTimeFormatter.ISO_LOCAL_DATE);
		}
		else
		{
			result = null;
		}
		return result;
	}

}
