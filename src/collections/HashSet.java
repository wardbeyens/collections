package collections;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HashSet implements Set {
	
	/**
	 * @invar | buckets != null
	 * @invar | IntStream.range(0, buckets.length).allMatch(i ->
	 *        |     buckets[i] != null &&
	 *        |     Arrays.stream(buckets[i].toArray()).allMatch(e -> Math.floorMod(e.hashCode(), buckets.length) == i))
	 * @representationObject
	 * @representationObjects
	 */
	private Set[] buckets;
	
	public HashSet(int capacity) {
		buckets = new Set[capacity];
		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new ArraySet();
	}
	
	private Set getBucket(Object object) {
		int hashCode = object.hashCode();
		return buckets[Math.floorMod(hashCode, buckets.length)];
	}
	
	public int size() {
		return Arrays.stream(buckets).mapToInt(bucket -> bucket.size()).sum();
	}

	public Object[] toArray() {
		return Arrays.stream(buckets).flatMap(bucket -> Arrays.stream(toArray())).toArray();
	}
	
	public boolean contains(Object object) {
		return getBucket(object).contains(object);
	}
	
	public void add(Object object) {
		getBucket(object).add(object);
	}
	
	public void remove(Object object) {
		getBucket(object).remove(object);
	}
	
}
