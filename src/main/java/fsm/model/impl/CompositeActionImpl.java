package fsm.model.impl;

import java.util.List;

import fsm.RetryException;
import fsm.model.Action;

/**
 * A "composite" Action which is composed of a set of {@link fsm.model.Action}.  When invoked,
 * it will iterate and invoke all the composition Actions.
 *
 * @param <T> The class of the Stateful Entity
 */
public class CompositeActionImpl<T> implements Action<T> {

	List<Action<T>> actions;
	
	public CompositeActionImpl(List<Action<T>> actions) {
		this.actions = actions;
	}
	
	public void execute(T stateful, String event, Object ... args) throws RetryException{
		for(Action<T> action : this.actions) {
			action.execute(stateful, event, args);
		}
	}

}
