
public class LinkedList implements List {
	
	private class Node {
		/**
		 * @peerObject
		 * @invar | (element == null) == (this == sentinel)
		 * @invar | previous != null
		 * @invar | next != null
		 * @invar | next.previous == this
		 * @invar | previous.next == this
		 */
		private Node previous;
		private Object element;
		/**
		 * @peerObject
		 */
		private Node next;
		
		private int getLength() { 
			return this == sentinel ? 0 : 1 + next.getLength();
		}
	}
	
	/**
	 * @invar | size == sentinel.next.getLength()
	 * 
	 */
	private int size = 0;
	/**
	 * @representationObject
	 * @invar | sentinel != null
	 */
	private Node sentinel;
	
	private Node getNode(int index) {
		Node node = sentinel;
		if (index <= size/2) {
			for (; index >= 0; index--) {
				node = node.next;
			}
		} else {
			for(; index < size; index++) {
				node = node.previous;
			}
		}
		return node;
	}
	
	/**
	 * @post | size() == 0
	 */
	public LinkedList() {
		sentinel = new Node();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
	}

	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		int i = 0;
		for (Node node = sentinel.next; node != sentinel; node = node.next) {
			result[i++] = node.element;
		}
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int index) {
		return getNode(index).element;
	}

	@Override
	public boolean contains(Object value) {
		for(Node node = sentinel.next; node != sentinel; node = node.next) {
			if(node.element.equals(value)) return true;
		}
		return false;
	}

	@Override
	public void add(int index, Object value) {
		Node next = getNode(index);
		Node node = new Node();
		node.previous = next.previous;
		node.element = value;
		node.next = next;
		node.next.previous = node;
		node.previous.next = node;
		size++;
		}

	@Override
	public void remove(int index) {
		Node node = getNode(index);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		size--;
	}

	@Override
	public void remove(Object value) {
		for(Node node = sentinel.next; node != sentinel; node = node.next) {
			if(node.element.equals(value)) {
				node.previous.next = node.next;
				node.next.previous = node.previous;
				size--;
				return;
			}
		}
		
	}

}
