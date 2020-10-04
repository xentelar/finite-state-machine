package fsm.model.impl;

import java.util.HashMap;
import java.util.Map;

import fsm.model.Action;
import fsm.model.State;
import fsm.model.Transition;

public class StateImpl<T> implements State<T> {

	private String name;
	private Map<String, Transition<T>> transitions = new HashMap<String, Transition<T>>();
	boolean isEndState = false;
	boolean isBlocking = false;
	
	public StateImpl() {
	}

	public StateImpl(String name) {
		if (name == null || name.trim().equals("")) {
			throw new RuntimeException("Name must be a non-empty value");
		}
		this.name = name;
	}

	public StateImpl(String name, boolean isEndState) {
		this(name);
		this.isEndState = isEndState;
	}

	public StateImpl(String name, boolean isEndState, boolean isBlocking) {
		this(name, isEndState);
		this.isBlocking = isBlocking;
	}

	public StateImpl(String name, Map<String, Transition<T>> transitions, boolean isEndState) {
		this(name, isEndState);
		this.transitions = transitions;
	}

	public StateImpl(String name, Map<String, Transition<T>> transitions, boolean isEndState, boolean isBlocking) {
		this(name, transitions, isEndState);
		this.isBlocking = isBlocking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Transition<T> getTransition(String event) {
		return transitions.get(event);
	}

	public Map<String, Transition<T>> getTransitions() {
		return transitions;
	}

	public void setTransitions(Map<String, Transition<T>> transitions) {
		this.transitions = transitions;
	}

	public boolean isEndState() {
		return isEndState;
	}

	public void setEndState(boolean isEndState) {
		this.isEndState = isEndState;
	}

	@Override
	public void addTransition(String event, State<T> next) {
		this.transitions.put(event, new DeterministicTransitionImpl<T>(next, null));
	}
	
	@Override
	public void addTransition(String event, State<T> next, Action<T> action) {
		this.transitions.put(event, new DeterministicTransitionImpl<T>(next, action));
	}
	
	@Override
	public void addTransition(String event, Transition<T> transition) {
		this.transitions.put(event, transition);
	}
	
	@Override
	public void removeTransition(String event) {
		this.transitions.remove(event);
	}

	@Override
	public void setBlocking(boolean isBlocking) {
		this.isBlocking = isBlocking;
	}

	@Override
	public boolean isBlocking() {
		return this.isBlocking;
	}
	
	@Override
	public String toString() {
		return "State[name=" + this.name + ", isEndState=" + this.isEndState + ", isBlocking=" + this.isBlocking +"]";
	}
}
