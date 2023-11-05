package com.example.SpringifiedLoanApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringifiedLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringifiedLoanApplication.class, args);
	}
}

/*
TODO:  Add the appropriate beans to the LoanAppConfig.xml file
TODO:  Set the minimum credit score in the application.properties file
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

 TODO:  re-run your tests.  Did they pass?  Notice that the tests are not using Spring at all.
  We will cover how to do unit testing with Spring in a subsequent section
 */
