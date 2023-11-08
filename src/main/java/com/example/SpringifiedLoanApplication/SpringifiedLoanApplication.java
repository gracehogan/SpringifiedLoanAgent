package com.example.SpringifiedLoanApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("application.properties")
@ComponentScan (basePackages = "com.example.SpringifiedLoanApplication")
public class SpringifiedLoanApplication {

	public static void main(String[] args) throws InvalidCreditScoreException {
		ApplicationContext context = SpringApplication.run(SpringifiedLoanApplication.class, args);

		ICreditAgency creditAgency = context.getBean("creditAgency", ICreditAgency.class);

		creditAgency.getCreditScore("111-11-1111");
		creditAgency.getCreditScore("333-33-3333");
		creditAgency.getCreditScore("444-44-4444");
		creditAgency.getCreditScore("999-99-9999");
		creditAgency.getCreditScore("555-55-5555");
		creditAgency.getCreditScore("222-22-2222");
		creditAgency.getCreditScore("dummy ssn");

		LoanAgent loanAgent = context.getBean("loanAgent", LoanAgent.class);
		ILoanApplication loanApplication = context.getBean("loanApplication", ILoanApplication.class);

		loanAgent.processLoanApplication(loanApplication);


	}

	/*
	Activity 1 directions

	TODO  Annotate the appropriate classes with @Component
	TODO Update the annotationsconfig.xml file
	TODO:  Create a dummy implementation of the ICreditAgency interface that
	returns 719 for a social security number of 111-11-1111
	returns 721 for a social security number of 333-33-3333
	returns 850 for a social security number of 444-44-4444
	returns 851 for a social security number of 999-99-9999
	returns 200 for a social security number of 555-55-5555
	returns 199 for a social security number of 222-22-2222
	defaults to a credit score of 720 for all other social security numbers

TODO:  create a dummy implementation of the ILoanApplication that returns a social security number.
 We will want to be able to return each of the social security numbers listed above

TODO:  add code to the processLoanApplication() function to print out the social security number,
 credit score and result of the method

TODO: Rewrite the main method to retrieve a loan agent object from the IOC container and then process
 loan applications using each of the social security numbers above
 Hint:  The return from the run() method is the ApplicationContext

 TODO:  re-run your tests.  Did they pass?  Notice that the tests are not using Spring at all.
  We will cover how to do unit testing with Spring in a subsequent section

  Something to note:  we have hardwired the minimum credit score into the LoanAgent.
  We will fix this in the next Loan Application exercise

	 */

	/*
	Activity 3 Directions
	TODO eliminate the hardwiring of the minimum credit score.
	 Read the initial minimum credit score from a .properties file

	 TODO  Add a name variable to the Credit Agency, which will be set from the .properties file
	 TODO  Print out the name of the credit agency in the printout of the results of the loan application

	 TODO  Use annotations so that we do not need the xml config file at all.
	 */
}
