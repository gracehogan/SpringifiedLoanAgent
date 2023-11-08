package originajunittests;

import com.example.SpringifiedLoanApplication.IErrorLog;
import com.example.SpringifiedLoanApplication.InvalidCreditScoreException;
import com.example.SpringifiedLoanApplication.LoanAgent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;

public class LoanAgentTests {
    LoanAgent uut;
    TestingLoanApplicationStub loanApplication;
    CreditAgencyTestingStub agency;
    IErrorLog errorLog;

    @BeforeEach
    public void setUp() {
        uut = new LoanAgent();
        loanApplication = new TestingLoanApplicationStub();
        agency = new CreditAgencyTestingStub();
        errorLog = new ErrorLogDummy();
        uut.setAgency(agency);
        uut.setMinimumCreditScore(720);
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
        agency.setCreditScore(creditScore);
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
        agency.setCreditScore(creditScore);
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
