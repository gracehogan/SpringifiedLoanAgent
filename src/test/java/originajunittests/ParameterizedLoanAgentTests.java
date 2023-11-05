package originajunittests;


import com.example.SpringifiedLoanApplication.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class ParameterizedLoanAgentTests {
    LoanAgent uut;
    ILoanApplication loanApplication;
    ICreditAgency agency;
    IErrorLog errorLog;

    @BeforeEach
    public void setUp() {
        uut = new LoanAgent();
        loanApplication = () -> {return "123-45-6789";};
        uut.setMinimumCreditScore(720);
        errorLog = mock(IErrorLog.class);
        uut.setErrorLog(errorLog);
    }

    @AfterEach
    public void teardown() {
        uut = null;
        agency = null;
    }

    @ParameterizedTest
    @CsvSource({"200, false", "719, false", "720, true", "721, true", "850, true"})
    public void testWithValidCreditScores(int creditScore, boolean expectedResult) {
        boolean actualResult;
        agency = (ssn) -> {return creditScore;};
        uut.setAgency(agency);

        try {
            actualResult = uut.processLoanApplication(loanApplication);
            assertEquals(expectedResult, actualResult);
        } catch (Exception e) {
            fail();
        }
    }

    @ParameterizedTest
    @CsvSource({"199", "851"})
    public void testWithInvalidCreditScores(int creditScore) {
        agency = (ssn) -> {return creditScore;};
        uut.setAgency(agency);

        assertAll("Exception assertions",
                () -> {
                    InvalidCreditScoreException invalid = assertThrows(InvalidCreditScoreException.class,
                            () -> {uut.processLoanApplication(loanApplication);
                            });
                    assertEquals(creditScore + " is not a valid credit score", invalid.getMessage());
                });
    }
}

