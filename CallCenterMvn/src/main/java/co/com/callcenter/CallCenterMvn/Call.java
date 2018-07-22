package co.com.callcenter.CallCenterMvn;

/**
 * Models a calling incoming to the call center
 * @author felipe.jimenez
 *
 */
public class Call {
	/**
	 * Min call duration
	 */
	public final static int MIN_CALL_DURATION_MS = 5000;
	/**
	 * Max call duration
	 */
	public final static int MAX_CALL_DURATION_MS = 10000;
	/**
	 * Calling status: pending (not attended yet) 
	 */
	public final static String STATUS_ATTENTION_PENDING = "PENDING";
	/**
	 * Calling status: attention in process 
	 */
	public final static String STATUS_IN_PROCESS = "IN_PROCESS";
	/**
	 * Calling status: attended 
	 */
	public final static String STATUS_ATTENDED = "ATTENDED";
	/**
	 * Calling status: not attended (calling was not attended) 
	 */
	public final static String STATUS_NOT_ATTENDED = "NOT_ATTENDED";

	private int callId;
	private String status;

	public Call() {
		super();
		status = STATUS_ATTENTION_PENDING;
	}

	public Call(int callId) {
		super();
		this.callId = callId;
		this.status = STATUS_ATTENTION_PENDING;
	}

	public int getCallId() {
		return callId;
	}

	public void setCallId(int callId) {
		this.callId = callId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
