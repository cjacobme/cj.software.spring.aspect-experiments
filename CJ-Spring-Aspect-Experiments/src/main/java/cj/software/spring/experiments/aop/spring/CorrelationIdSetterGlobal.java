package cj.software.spring.experiments.aop.spring;

import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 0)
public class CorrelationIdSetterGlobal
		extends CorrelationIdSetter
{

	@Around("execution(* cj.software.spring.experiments.aop.rest..*.*(..))")
	@Order(value = 1)
	public Object aroundGlobal(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Object result = around(joinPoint, UUID.randomUUID().toString());
		return result;
	}
}
