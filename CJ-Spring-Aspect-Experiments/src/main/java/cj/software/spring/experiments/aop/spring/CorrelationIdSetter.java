package cj.software.spring.experiments.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.MDC;

public abstract class CorrelationIdSetter
{

	protected Object around(ProceedingJoinPoint joinPoint, String correlationId) throws Throwable
	{
		String oldCorrelationId = MDC.get("correlationId");
		try
		{
			MDC.put("correlationId", correlationId);
			Object result = joinPoint.proceed();
			return result;
		}
		finally
		{
			MDC.put("correlationId", oldCorrelationId);
		}
	}

}
