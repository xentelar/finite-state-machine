package fsm.model;

import fsm.RetryException;

/**
 * A Transition is a "reaction" to an Event based off the {@link fsm.model.State} of the Stateful Entity.
 * It is comprised of an optional next State value and an optional {@link fsm.model.Action}
 *
 * @param <T> The class of the Stateful Entity
 */
public interface Transition<T> {

	/**
	 * Return the {@link fsm.model.StateActionPair}
	 *
	 * @param stateful the Stateful Entity
	 *
	 * @return the {@link fsm.model.StateActionPair}
	 * @param event The occurring Event
	 * @param args Optional parameters that was passed into the FSM
	 *
	 * @throws RetryException is thrown if there is an error determining the next State and Action and the FSM should
	 *         re-process the event
	 */
	StateActionPair<T> getStateActionPair(T stateful, String event, Object ... args) throws RetryException;
}
