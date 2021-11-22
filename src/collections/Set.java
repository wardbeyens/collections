package collections;

import java.util.Arrays;

/**
 * @invar | Arrays.stream(toArray()).allMatch(e -> e != null)
 */
public interface Set {
	
	/**
	 * @basic
	 * @inspects | this
	 * @post | result != null
	 */
	public Object[] toArray();
	
	/**
	 * @inspects | this
	 * @post | result == toArray().length
	 */
	public default int size() { return toArray().length; }
	
	/**
	 * @inspects | this
	 * @post | result == Arrays.stream(toArray()).anyMatch(e -> e.equals(object))
	 */
	public boolean contains(Object object);
	
	/**
	 * @pre | object != null
	 * @mutates | this
	 * @post | contains(object)
	 * @post | Arrays.stream(old(toArray())).allMatch(e -> contains(e))
	 * @post | Arrays.stream(toArray()).allMatch(e -> e.equals(object) || Arrays.stream(old(toArray())).anyMatch(e1 -> e1 == e))
	 * @post | size() == (Arrays.stream(old(toArray())).anyMatch(e -> e.equals(object)) ? old(size()) : old(size()) + 1)
	 */
	public void add(Object object);
	
	/**
	 * @pre | object != null
	 * @mutates | this
	 * @post | Arrays.stream(old(toArray())).allMatch(e -> e.equals(object) || contains(e))
	 * @post | Arrays.stream(toArray()).allMatch(e -> !e.equals(object) && Arrays.stream(old(toArray())).anyMatch(e1 -> e1 == e))
	 */
	public void remove(Object object);

}
