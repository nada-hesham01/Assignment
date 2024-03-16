import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.example.LoanProcessor;

public class LoanProcessorTest {
    private LoanProcessor processor;

    @Before
    public void setUp() {
        processor = new LoanProcessor();
    }

    @Test
    public void testApplicationRejectedDueToLowCreditScore() {
        assertEquals("Rejected: Credit score too low", processor.processLoanApplication(550, true, 20000));
    }

    @Test
    public void testApplicationRejectedDueToUnemployment() {
        assertEquals("Rejected: Applicant must be employed", processor.processLoanApplication(650, false, 20000));
    }

    @Test
    public void testApplicationRejectedDueToHighLoanAmount() {
        assertEquals("Rejected: Loan amount too high", processor.processLoanApplication(700, true, 60000));
    }

    @Test
    public void testApplicationApproved() {
        assertEquals("Approved", processor.processLoanApplication(700, true, 20000));
    }
}
