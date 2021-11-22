package collections;

import java.util.Arrays;

public interface Map {
	
	/**
	 * @immutable
	 */
	interface Entry {
		/**
		 * @post | result != null
		 * @basic
		 */
		Object getKey();
		/**
		 * @post | result != null
		 * @basic
		 */
		Object getValue();
		
		/**
		 * @post | result == (
		 *       |     other instanceof Entry &&
		 *       |     ((Entry)other).getKey().equals(getKey()) &&
		 *       |     ((Entry)other).getValue().equals(getValue())
		 *       | )
		 */
		@Override
		public boolean equals(Object other);
	}

	/**
	 * @basic
	 * @inspects | this
	 * @post | result != null
	 * @post | Arrays.stream(result.toArray()).allMatch(e -> e instanceof Entry)
	 * @post | Arrays.stream(result.toArray()).map(e -> ((Entry)e).getKey()).distinct().count() == result.size()
	 */
	public Set entrySet();
	
	/**
	 * @inspects | this
	 * @post | result == entrySet().size()
	 */
	public default int size() { return entrySet().size(); }

	/**
	 * @pre | object != null
	 * @inspects | this
	 * @post | result == Arrays.stream(entrySet().toArray()).anyMatch(e -> ((Entry)e).getKey().equals(object))
	 */
	public boolean containsKey(Object object);
	
	/**
	 * @pre | key != null
	 * @inspects | this
	 * @post | result == Arrays.stream(entrySet().toArray())
	 *       |                 .filter(e -> ((Entry)e).getKey().equals(key))
	 *       |                 .map(e -> ((Entry)e).getValue())
	 *       |                 .findFirst().orElse(null)
	 */
	public Object get(Object key);

	/**
	 * @pre | key != null
	 * @pre | value != null
	 * @mutates | this
	 * @post | Arrays.stream(entrySet().toArray()).allMatch(e ->
	 *       |     ((Entry)e).getKey().equals(key) && ((Entry)e).getValue().equals(value) ||
	 *       |     !((Entry)e).getKey().equals(key) && Arrays.stream(old(entrySet().toArray())).anyMatch(e1 -> e1.equals(e)))
	 * @post | containsKey(key)
	 * @post | get(key) == value
	 * @post | Arrays.stream(old(entrySet().toArray())).allMatch(e ->
	 *       |     ((Entry)e).getKey().equals(key) ||
	 *       |     containsKey(((Entry)e).getKey()) && get(((Entry)e).getKey()) == ((Entry)e).getValue())
	 */
	public void put(Object key, Object value);
	
	/**
	 * @pre | key != null
	 * @mutates | this
	 * @post | Arrays.stream(entrySet().toArray()).allMatch(e ->
	 *       |     !((Entry)e).getKey().equals(key) && old(entrySet()).contains(e))
	 * @post | Arrays.stream(old(entrySet().toArray())).allMatch(e ->
	 *       |     ((Entry)e).getKey().equals(key) || containsKey(((Entry)e).getKey()) && get(((Entry)e).getKey()) == ((Entry)e).getValue())
	 */
	public void remove(Object key);
}
