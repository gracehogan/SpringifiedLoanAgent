package originajunittests;

import com.example.SpringifiedLoanApplication.ILoanApplication;

public class TestingLoanApplicationStub implements ILoanApplication {
    @Override
    public String getSSN() {
        return "dummy ssn";
    }
}
