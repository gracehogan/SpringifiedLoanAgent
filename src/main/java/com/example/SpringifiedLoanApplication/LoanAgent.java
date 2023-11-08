package com.example.SpringifiedLoanApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component(value = "loanAgent")
public class LoanAgent {
    ICreditAgency agency;

    @Value("${minimumCreditScore}")
    int minimumCreditScore;

    IErrorLog errorLog;

    public boolean processLoanApplication(ILoanApplication application) throws InvalidCreditScoreException {
        boolean response = false;
        System.out.println(agency.getName());
        String ssn = application.getSSN();
        System.out.println(ssn);
        int creditScore = agency.getCreditScore(ssn);
        System.out.println(creditScore);
        if(creditScore < 200 || creditScore > 850) {
            errorLog.log(creditScore + " is not a valid credit score");
            throw new InvalidCreditScoreException(creditScore + " is not a valid credit score");
        }
        if(creditScore >= minimumCreditScore) {
            response = true;
        }
        return response;
    }

    public ICreditAgency getAgency() {
        return agency;
    }

    @Autowired
    public void setAgency(ICreditAgency agency) {
        this.agency = agency;
    }

    public int getMinimumCreditScore() {
        return minimumCreditScore;
    }

    public void setMinimumCreditScore(int minimumCreditScore) {
        this.minimumCreditScore = minimumCreditScore;
    }

    @Autowired
    public void setErrorLog(IErrorLog errorLog) {
        this.errorLog = errorLog;
    }
}
