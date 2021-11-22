package collections;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this interface stores a sequence of objects.
 * 
 * @invar | Arrays.stream(toArray()).allMatch(e -> e != null)
 */
public interface List {

	/**
	 * @inspects | this
	 * @basic
	 * 
	 * @post | result != null
	 */
	public Object[] toArray();
	
	/**
	 * @inspects | this
	 * @post | result == toArray().length
	 */
	public default int size() { return toArray().length; }
	
	/**
	 * @pre | 0 <= index && index < size()
	 * @inspects | this
	 * @post | result == toArray()[index]
	 */
	public default Object get(int index) { return toArray()[index]; }
	
	/**
	 * @pre | object != null
	 * @inspects | this
	 * @post | result == Arrays.stream(toArray()).anyMatch(e -> e.equals(object))
	 */
	public default boolean contains(Object object) { return Arrays.stream(toArray()).anyMatch(e -> e.equals(object)); }
	
	/**
	 * @pre | element != null
	 * @mutates | this
	 * @post | Arrays.equals(toArray(), 0, size() - 1, old(toArray()), 0, old(size()))
	 * @post | toArray()[old(size())] == element
	 */
	public void add(Object element);
	
	/**
	 * @pre | 0 <= index
	 * @pre | index < size()
	 * @mutates | this
	 * @post | size() == old(size()) - 1
	 * @post | Arrays.equals(toArray(), 0, index, old(toArray()), 0, index)
	 * @post | Arrays.equals(toArray(), index, size(), old(toArray()), index + 1, old(size()))
	 */
	public void remove(int index);
	
	/**
	 * @pre | 0 <= index
	 * @pre | index < size()
	 * @mutates | this
	 * @post | size() == old(size())
	 * @post | IntStream.range(0, size()).allMatch(i -> toArray()[i] == (i == index ? element : old(toArray())[i]))
	 */
	public void set(int index, Object element);
	
}
