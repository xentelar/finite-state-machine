package fsm;

import fsm.model.State;

import java.util.Collection;

/**
 * A Persister is responsible for maintaining the persistence of the current State of the
 * FSM
 *
 */
public interface Persister<T> {

	/**
	 * Returns the current state.  This will not call into the  underlying database
	 *
	 * @param stateful Stateful Entity
	 * @return current State of the Stateful Entity
	 */
	State<T> getCurrent(T stateful);

	/**
	 * Set the current state to the next state.  Will serialize access to the persistence
	 * and ensure that expected current state is indeed the current state.  If not, will throw
	 * a StaleStateException
	 *
	 * @param stateful StatefulEntity
	 * @param current Expected current State of the Stateful Entity
	 * @param next The value of the updated State
	 * @throws StaleStateException thrown if the state value of the Stateful Entity is not equal to the passed in current
	 * value
	 */
	void setCurrent(T stateful, State<T> current, State<T> next) throws StaleStateException;

	/**
	 * Set the Collection of States to be managed by the Persister
	 * @param states Collection of States
	 */
	void setStates(Collection<State<T>> states);

	/**
	 * Set the Start State
	 * @param startState Start State
	 */
	void setStartState(State<T> startState);
}
