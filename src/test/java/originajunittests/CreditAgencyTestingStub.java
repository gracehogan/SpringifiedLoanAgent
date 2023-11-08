package originajunittests;

import com.example.SpringifiedLoanApplication.ICreditAgency;
import org.springframework.beans.factory.annotation.Value;

public class CreditAgencyTestingStub implements ICreditAgency {


    String name;
    int creditScore;
    @Override
    public int getCreditScore(String ssn) {
        return creditScore;
    }

    @Override
    public String getName() {
        return name;
    }


    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }
}
