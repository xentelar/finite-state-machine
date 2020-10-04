package fsm.model.impl;

import fsm.RetryException;
import fsm.WaitAndRetryException;
import fsm.model.Action;

/**
 * Action with throws a {@link WaitAndRetryException}
 * 
 *
 * @param <T>
 */
public class WaitAndRetryActionImpl<T> implements Action<T> {
	
	private int wait = 0;

	/**
	 * Constructor with a wait time expressed in milliseconds
	 * 
	 * @param wait time in milliseconds
	 */
	public WaitAndRetryActionImpl(int wait) {
		this.wait = wait;
	}
	
	@Override
	public void execute(T obj, String event, Object... args) throws RetryException {
		throw new WaitAndRetryException(this.wait);
	}

}
