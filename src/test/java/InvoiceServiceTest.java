import com.bridgeLabz.ttdProject.InvocieService;
import com.bridgeLabz.ttdProject.InvocieSummary;
import com.bridgeLabz.ttdProject.Ride;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvocieService invocieService=null;
    @Before
    public void setUp(){
        invocieService = new InvocieService();
    }
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance=2.0;
        int time=5;
      double fare=  invocieService.calculatorFare(distance,time);
        Assert.assertEquals(25,fare,0.0);
    }

    @Test
    public void givenLessDistanceAndTimeShouldReturnFare() {
        double distance=0.1;
        int time=1;
        double fare=  invocieService.calculatorFare(distance,time);
        Assert.assertEquals(5,fare,0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummery() {
         Ride[] rides ={new Ride( 2.0, 5 ),
                    new Ride(0.1,1)
        } ;
       InvocieSummary summary= invocieService.calculatorFare( rides );
        InvocieSummary expectedInvocieSummary = new InvocieSummary( 2, 30.0 );
        Assert.assertEquals( expectedInvocieSummary,summary );
    }

    @Test
    public void givenUserIdAndRide_ShouldReturnInvoiceSummary() {
        String userId="a@b.com";
        Ride[] rides={
                new Ride( 2.0,5 ),
                new Ride( 0.1,1 )
        };
        invocieService.addRides( userId,rides );
        InvocieSummary summary =invocieService.getInvocieSummary(userId);
        InvocieSummary expectedSummary =new InvocieSummary( 2,30.0 );
        Assert.assertEquals( expectedSummary,summary );
    }
}
