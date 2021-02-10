package cj.software.spring.experiments.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class CorrelationIdSetterForContract
		extends CorrelationIdSetter
{

	@Around("execution(* cj.software.spring.experiments.aop.rest.contract.*.*(Long, ..))"
			+ "&& args(id)")
	public Object aroundContract(ProceedingJoinPoint joinPoint, Long id) throws Throwable
	{
		String correlationId = String.format("Contract %d", id);
		return around(joinPoint, correlationId);
	}
}
