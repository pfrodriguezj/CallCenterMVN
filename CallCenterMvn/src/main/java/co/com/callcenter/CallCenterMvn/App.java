package co.com.callcenter.CallCenterMvn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 *
 */
public class App 
{
	public static int NUM_LLAMADAS = 50;
	
	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(10);
		int i = 0;
		while (i<NUM_LLAMADAS) {
			int callId = (int)Math.floor(new Double(Math.random())  * 1000);
			Call call = new Call(callId);
			Staff.initialize(4, 2, 1);
			Runnable worker = new Dispatcher(call);
			es.execute(worker);
			i++;
		}
		es.shutdown();
        while (!es.isTerminated()) {
        }
        System.out.println("Operation closed");
	}
}
