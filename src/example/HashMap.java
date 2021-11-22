package example;

import java.util.Arrays;
import java.util.stream.IntStream;

public class HashMap implements Map {
	
	
	/**
	 * @representationObject
	 * @representationObjects each bucket is a representation object
	 * @invar | buckets != null
	 * @invar | Arrays.stream(buckets).allMatch(b -> b != null)
	 * @invar | IntStream.range(0, buckets.length).allMatch(i ->
	 *        |     buckets[i].entrySet().stream().allMatch(e -> 
	 *        |         Math.floorMod(((Entry)e).getKey().hashCode(), buckets.length) == i))
	 * 
	 */
	private Map[] buckets;
	
	private Map getBucket(Object key) {
		return buckets[Math.floorMod(key.hashCode(), buckets.length)];
	}
	
	

	/**
	 * @pre | capacity > 0
	 * @post | entrySet().size() == 0
	 */
	public HashMap(int capacity) {
		buckets = new Map[capacity];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayMap();
		}
	}


	@Override
	public Set entrySet() {
		Set result = new ArraySet();
		for (int i = 0; i < buckets.length; i++) {
			Object[] a = buckets[i].entrySet().toArray();
			for (int j = 0; j < a.length; j++) {
				Object entry = a[j];
				result.add(entry);
			}
		}
		return result;
	}

	@Override
	public Object get(Object key) {
		return getBucket(key).get(key);
	}

	@Override
	public void put(Object key, Object value) {
		getBucket(key).put(key, value);	
	}

	@Override
	public void remove(Object key) {
		getBucket(key).remove(key);	
	}


	@Override
	public boolean containsKey(Object object) {
		return getBucket(object).containsKey(object);
	}

}
