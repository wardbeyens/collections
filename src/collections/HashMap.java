package collections;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HashMap implements Map {
	
	/**
	 * @invar | buckets != null
	 * @invar | IntStream.range(0, buckets.length).allMatch(i ->
	 *        |     buckets[i] != null &&
	 *        |     Arrays.stream(buckets[i].entrySet().toArray()).allMatch(e ->
	 *        |         Math.floorMod(((Entry)e).getKey().hashCode(), buckets.length) == i))
	 * @representationObject
	 * @representationObjects
	 */
	private Map[] buckets;
	
	private Map getBucket(Object key) {
		return buckets[Math.floorMod(key.hashCode(), buckets.length)];
	}
	
	public Set entrySet() {
		Set result = new ArraySet();
		for (Map bucket : buckets)
			for (Object e : bucket.entrySet().toArray())
				result.add(e);
		return result;
	}
	
	public int size() {
		return Arrays.stream(buckets).mapToInt(bucket -> bucket.size()).sum();
	}
	
	public boolean containsKey(Object key) {
		return getBucket(key).containsKey(key);
	}
	
	public Object get(Object key) {
		return getBucket(key).get(key);
	}
	
	/**
	 * @post | size() == 0
	 */
	public HashMap() {
		buckets = new Map[10];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayMap();
		}
	}
	
	public void put(Object key, Object value) {
		getBucket(key).put(key, value);
	}
	
	public void remove(Object key) {
		getBucket(key).remove(key);
	}

}
