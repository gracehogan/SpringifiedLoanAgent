package com.example.SpringifiedLoanApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name="loanAgent")
    public LoanAgent getLoanAgent(){
        return new LoanAgent();
    }

    @Bean(name="creditAgency")
    public ICreditAgency getCreditAgency(){
        return new CreditAgency();
        }
}
