package cj.software.spring.experiments.aop.spring;

import java.util.UUID;

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

	@Around("execution(* cj.software.spring.experiments.aop.rest.contract.*.*(java.util.UUID, ..))"
			+ "&& args(id, ..)")
	public Object aroundContract(ProceedingJoinPoint joinPoint, UUID id) throws Throwable
	{
		String correlationId = "C " + id.toString();
		return around(joinPoint, correlationId);
	}
}
