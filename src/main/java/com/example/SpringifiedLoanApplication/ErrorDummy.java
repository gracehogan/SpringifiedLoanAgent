package com.example.SpringifiedLoanApplication;

import org.springframework.stereotype.Component;

@Component
public class ErrorDummy implements IErrorLog{
    @Override
    public void log(String message) {

    }
}
