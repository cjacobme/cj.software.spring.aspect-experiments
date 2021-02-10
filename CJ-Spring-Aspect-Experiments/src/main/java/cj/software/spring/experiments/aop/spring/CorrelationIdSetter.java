package cj.software.spring.experiments.aop.spring;

import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CorrelationIdSetter
{

	@Around("execution(* cj.software.spring.experiments.aop.rest..*.*(..))")
	public Object aroundGlobal(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Object result;
		if (MDC.get("correlationId") == null)
		{
			result = around(joinPoint, UUID.randomUUID().toString());
		}
		else
		{
			result = joinPoint.proceed();
		}
		return result;
	}

	private Object around(ProceedingJoinPoint joinPoint, String correlationId) throws Throwable
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

	@Around("execution(* cj.software.spring.experiments.aop.rest.contract.*.*(Long, ..))"
			+ "&& args(id)")
	public Object aroundContract(ProceedingJoinPoint joinPoint, Long id) throws Throwable
	{
		String correlationId = String.format("Contract %d", id);
		return around(joinPoint, correlationId);
	}
}
