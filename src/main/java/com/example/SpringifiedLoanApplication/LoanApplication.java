package com.example.SpringifiedLoanApplication;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component (value = "loanApplication")
public class LoanApplication implements ILoanApplication{
    public String getSSN() {
        List<String>  ssnList = new ArrayList<>();
        ssnList.add("111-11-1111");
        ssnList.add("333-33-3333");
        ssnList.add("444-44-4444");
        ssnList.add("999-99-9999");
        ssnList.add("555-55-5555");
        ssnList.add("222-22-2222");
        ssnList.add("dummy ssn");

        int randomIndex = (int) (Math.random()*6);

        return ssnList.get(randomIndex);


    }
}
