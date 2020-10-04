package fsm.model;

/**
 * A {@link fsm.model.State}/{@link fsm.model.Action} pair
 * @author Andrew Hall
 *
 * @param <T>
 */
public interface StateActionPair<T> {
	
	/**
	 * @return the {@link fsm.model.State}
	 */
	State<T> getState();

	/**
	 * @return {@link fsm.model.Action}
	 */
	Action<T> getAction();
	
}
