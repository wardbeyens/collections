package example;

import java.util.stream.IntStream;

public class ArrayMap implements Map {
	
	/**
	 * @representationObject
	 * @invar | entries != null
	 * @invar | entries.stream().allMatch(e -> e instanceof Entry)
	 * @invar | entries.stream().map(e -> ((Entry)e).getKey()).distinct().count() == entries.size()
	 */
	private ArrayList entries = new ArrayList();

	
	private int indexOf(Object key) {
		return IntStream.range(0, entries.size()).filter(i -> ((Entry)entries.get(i)).getKey().equals(key)).findFirst().orElse(-1);
	}
	
	
	/**
	 * @post | entrySet().size() == 0
	 */
	public ArrayMap() {	}


	@Override
	public Set entrySet() {
		Set result = new ArraySet();
		for (int i = 0; i < entries.size(); i++) {
			result.add(entries.get(i));
		}
		return result;
	}

	@Override
	public Object get(Object key) {
		int index  = indexOf(key);
		return index != -1 ? ((Entry)entries.get(index)).getValue() : null;
	}

	@Override
	public void put(Object key, Object value) {
		int index = indexOf(key);
		if (index != -1) {
			entries.remove(index);
		}
		entries.add(new Entry(key, value));
	}

	@Override
	public void remove(Object key) {
		int index = indexOf(key);
		if (index != -1) {
			entries.remove(index);
		}
	}


	@Override
	public boolean containsKey(Object object) {
		int index  = indexOf(object);
		return index != -1;
	}

}
