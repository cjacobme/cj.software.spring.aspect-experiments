package cj.software.spring.experiments.aop.aspetctj;

public aspect Builder 
{
	/*
	pointcut getContractDetail() 
		: call (public * cj.software.spring.experiments.aop.dao.ContractRepository.getContractDetail(Long));
	
	after() returning() : getContractDetail() 
	{
		System.err.println("Builder.afterReturning() getContractDetail");
	}
	
	pointcut builderInvoked() : call 
		(public * cj.software.spring.experiments.aop.entity.ContractsGetOutput.Builder.withEntries(*));
	
	pointcut setInBuilder() : withincode(public * cj.software..*.Builder.with*(..));
	
	before() : setInBuilder() {
		System.err.println("set in builder");
	}
	*/
}
