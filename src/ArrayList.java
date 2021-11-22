import java.util.Arrays;

public class ArrayList implements List{
		
	/**
	 * @invar | elements != null
	 * @invar | 0 <= size
	 * @invar | size <= elements.length
	 */
	private int size;
	/**
	 * @representationObject
	 */
	private Object[] elements = new Object[10];
	
	public Object[] toArray() { return Arrays.copyOf(elements, size); }
	
	public int size() { return size; }
	
	public Object get(int index) { return elements[index]; }
	
	public boolean contains(Object object) {
		for (int i = 0; i < size; i++)
			if (elements[i].equals(object))
				return true;
		return false;
	}
	
	/**
	 * @post | size() == 0
	 */
	public ArrayList() {	}
	
	public void add(int index, Object value) {
		if (elements.length == size) {
			Object[] newElements = new Object[elements.length * 2];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
		System.arraycopy(elements, index, elements, index + 1, size - index);
		elements[index] = value;
		size++;
	}
	
	public void set(int index, Object element) {
		elements[index] = element;
	}
	
	public void remove(int index) {
		System.arraycopy(elements, index + 1, elements, index, size - index - 1);
		size--;
	}

	public void remove(Object value) {
		int index = -1;
		for (int i = 0; i < size; i++)
			if (elements[i].equals(value)) {
				index = i;
				break;
		}
		
		if (index != -1)
			remove(index);
	}
	
}
