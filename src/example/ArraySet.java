package example;

public class ArraySet implements Set {
	
	/**
	 * @representationObject
	 * @invar | elements != null
	 * @invar | elements.stream().distinct().count() == elements.size()
	 */
	private ArrayList elements = new ArrayList();
	
	/**
	 * @post | size() == 0
	 */
	public ArraySet() {}

	@Override
	public Object[] toArray() {
		return elements.toArray();
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	public boolean contains(Object value) {
		return elements.contains(value);
	}

	@Override
	public void add(Object value) {
		if (!elements.contains(value)) {
			elements.add(value);
		}
	}

	@Override
	public void remove(Object value) {
		elements.remove(value);
	}

}
