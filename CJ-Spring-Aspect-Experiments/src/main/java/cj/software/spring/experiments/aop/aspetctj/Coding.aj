package cj.software.spring.experiments.aop.aspetctj;

public aspect Coding {
	declare error
		: get(java.io.PrintStream System.out) && within(cj.software..*..*)
		: "illegal access to System.out";
	
//	declare warning
//		: set(private * *) 
//			&& ! withincode(* cj.software..*.set*(..))
//			&& ! withincode(public cj.software..*.new(..))
//		: "access to private field";
}
