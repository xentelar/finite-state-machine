package fsm;

/**
 * Indicates that the evaluated State was inconsistent with the Persisted State
 *
 */
public class StaleStateException extends RetryException {


	private static final long serialVersionUID = 1L;

	public StaleStateException() {
		super();
	}
	
	public StaleStateException(String err) {
		super(err);
	}
}
