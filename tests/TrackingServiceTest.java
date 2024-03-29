import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by christopher.monney on 21/01/14.
 */
public class TrackingServiceTest {

    private TrackingService service;

    @BeforeClass
    public static  void before(){
        System.out.println("Before Class");
    }

    @AfterClass
    public static  void after(){
        System.out.println("After Class");
    }

    @Before
    public void setUp() {
        System.out.println("Before");
        service = new TrackingService();
    }

    @After
    public void tearDown(){
        System.out.println("After");
    }

    @Test
    public void NewTrackingServiceTotalIsZero() {

        assertEquals("Tracking service total was not zero", 0, service.getTotal());
    }

    @Test
    public void WhenAddingProteinTotalIncreasesByThatAmount() {

        service.addProtein(10);

        assertEquals("Protein amount was not correct", 10, service.getTotal());
    }

    @Test
    //@Ignore
    public void WhenRemovingProteinTotalRemainZero() {

        service.removeProtein(5);
        assertEquals(0, service.getTotal());
    }

    @Test(expected = InvalidGoalException.class)
    public void WhenGoalIsSetToLessThanZeroExceptionIsThrown() throws InvalidGoalException {
        service.setGoal(-5);
    }

    @Test(timeout = 200)
    public void BadTest(){
        for (int i = 0; i < 10000000; i++)
            service.addProtein(1);
    }
}
