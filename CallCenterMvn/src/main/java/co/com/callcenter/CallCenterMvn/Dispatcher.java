package co.com.callcenter.CallCenterMvn;

import java.util.List;

/**
 * models the process of attention for a calling, each calling triggers a thread
 * @author felipe.jimenez
 *
 */
public class Dispatcher implements Runnable{

	Call call;

	public Dispatcher(Call call) {
		this.call = call;
	}

	public void run() {
		processCall();
	}
	
	private void processCall() {
		try {
			Empleado emp = Staff.getAvailableEmployee();
			if(emp == null) {
				System.out.println("no hay empleados disponibles");
				call.setStatus(Call.STATUS_NOT_ATTENDED);
			} else {
				System.out.println("Attending call " + call.getCallId() + " - Employee " + emp.getCodigo());
				call.setStatus(Call.STATUS_IN_PROCESS);
				Double callDurationMs =  (Math.random() * (Call.MAX_CALL_DURATION_MS-Call.MIN_CALL_DURATION_MS))+Call.MIN_CALL_DURATION_MS;
				System.out.println("Duration " + callDurationMs);
	            Thread.sleep(callDurationMs.intValue());
	            emp.setAvailable(true);
	            call.setStatus(Call.STATUS_ATTENDED);
	            System.out.println("Ending call " + call.getCallId());
			}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
