import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @invar | Arrays.Stream(toArray()).allMatch(e -> e != null)
 * @invar | Arrays.Stream(toArray()).distinct().count() == size()
 *
 */
public interface Set {

	/**
	 * @inspects | this
	 * @creates | result
	 * @post | result != null
	 */
	Object[] toArray();
	
	default Stream<Object> stream() {return Arrays.stream(toArray());}
	
	/**
	 * 2 
	 */
	int size();
	
	boolean contains();
	
	void add(Object value);
	
	void remove(Object value);
}
