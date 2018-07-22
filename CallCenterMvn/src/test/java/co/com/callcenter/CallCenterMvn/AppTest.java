package co.com.callcenter.CallCenterMvn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
	public void testAvailableEmps() {
		int NUM_LLAMADAS = 50;
		Staff.initialize(4, 2, 1);
		ExecutorService es = Executors.newFixedThreadPool(10);
		int i = 0;
		while (i<NUM_LLAMADAS) {
			int callId = (int)Math.floor(new Double(Math.random())  * 1000);
			Call call = new Call(callId);
			Runnable worker = new Dispatcher(call);
			es.execute(worker);
			i++;
		}
		es.shutdown();
        while (!es.isTerminated()) {
        }

        assertEquals(Staff.getAvailableEmployees(), 7);
				
	}

	public void testAttendedCallings() {
		int NUM_LLAMADAS = 50;
		Staff.initialize(4, 2, 1);
		ExecutorService es = Executors.newFixedThreadPool(10);
		int i = 0;
		List<Call>attendedCallings = new ArrayList<Call>();
		while (i<NUM_LLAMADAS) {
			int callId = (int)Math.floor(new Double(Math.random())  * 1000);
			Call call = new Call(callId);
			attendedCallings.add(call);
			Runnable worker = new Dispatcher(call);
			es.execute(worker);
			i++;
		}
		es.shutdown();
        while (!es.isTerminated()) {
        }

        int numAttendedCallings=0;
        for(Call c:attendedCallings) {
        	if(c.getStatus().equals(Call.STATUS_ATTENDED)) {
        		numAttendedCallings++;
        	}
        }
        int numNotAttendedCallings=0;
        for(Call c:attendedCallings) {
        	if(c.getStatus().equals(Call.STATUS_NOT_ATTENDED)) {
        		numNotAttendedCallings++;
        	}
        }
        assertEquals(numAttendedCallings + numNotAttendedCallings, NUM_LLAMADAS);
	}
}
