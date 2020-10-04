package fsm.model;

import fsm.FSM;
import fsm.RetryException;

/**
 * Interface for an Action Class.  The Action is invoked as part of a State Transition.
 *
 *
 *
 * @param <T> The class of the Stateful Entity
 */
public interface Action<T> {

	/**
	 * Called to execute an action based off a State Transition.
	 *
	 * @param stateful The Stateful Entity
	 * @param event The ocurring Event
	 * @param args A set of optional arguments passed into the onEvent method of the {@link fsm.FSM}
	 * @throws RetryException thrown when the event must be retried due to Stale state or some other error condition
	 */
	void execute(T stateful, String event, Object ... args) throws RetryException;

}
