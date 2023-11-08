package com.example.SpringifiedLoanApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component(value = "creditAgency")
public class CreditAgency implements ICreditAgency {

    @Value("${companyName}")
    String name;
    HashMap<String, Integer> creditScores = new HashMap<>();
    public int getCreditScore(String ssn) {
        creditScores.put("111-11-1111", 719);
        creditScores.put("333-33-3333", 721);
        creditScores.put("444-44-4444", 850);
        creditScores.put("999-99-9999", 851);
        creditScores.put("555-55-5555", 200);
        creditScores.put("222-22-2222", 199);
        if (creditScores.containsKey(ssn)) {
            return creditScores.get(ssn);
        }
        else return 720;
    }

    public String getName() {
        return name;
    }
}
