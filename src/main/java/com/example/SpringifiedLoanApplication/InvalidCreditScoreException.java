package com.example.SpringifiedLoanApplication;

public class InvalidCreditScoreException extends Exception{

    public InvalidCreditScoreException(String message) {
        super(message);
    }
}
