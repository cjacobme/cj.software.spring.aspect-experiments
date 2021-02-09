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

	@Around("execution(* cj.software.spring.experiments.aop.rest.*.*(..))")
	public Object setCorrelationId(ProceedingJoinPoint joinPoint) throws Throwable
	{
		String oldCorrelationId = MDC.get("correlationId");
		try
		{
			MDC.put("correlationId", UUID.randomUUID().toString());
			Object result = joinPoint.proceed();
			return result;
		}
		finally
		{
			MDC.put("correlationId", oldCorrelationId);
		}
	}
}
