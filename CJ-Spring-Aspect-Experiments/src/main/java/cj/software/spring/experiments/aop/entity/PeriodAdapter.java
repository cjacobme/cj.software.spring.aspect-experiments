package cj.software.spring.experiments.aop.entity;

import java.time.Period;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PeriodAdapter
		extends XmlAdapter<String, Period>
{

	@Override
	public Period unmarshal(String value) throws Exception
	{
		Period result;
		if (value != null)
		{
			result = Period.parse(value);
		}
		else
		{
			result = null;
		}
		return result;
	}

	@Override
	public String marshal(Period value) throws Exception
	{
		String result;
		if (value != null)
		{
			result = value.toString();
		}
		else
		{
			result = null;
		}
		return result;
	}

}
