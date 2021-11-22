package collections;

import java.util.Arrays;

public class ArraySet implements Set {
	
	/**
	 * @invar | elements != null
	 * @invar | Arrays.stream(elements.toArray()).distinct().count() == elements.size()
	 * 
	 * @representationObject
	 */
	private ArrayList elements = new ArrayList();
	
	public Object[] toArray() { return elements.toArray(); }
	
	public int size() { return elements.size(); }
	
	public boolean contains(Object object) { return elements.contains(object); }

	/**
	 * @post | size() == 0
	 */
	public ArraySet() {
	}
	
	public void add(Object object) {
		if (!contains(object))
			elements.add(object);
	}
	
	public void remove(Object object) {
		for (int i = 0; i < elements.size(); i++)
			if (elements.get(i).equals(object)) {
				elements.remove(i);
				return;
			}
	}

}
