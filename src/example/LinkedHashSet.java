package example;

public class LinkedHashSet implements Set{
	
	private class Node {
		/**
		 * 
		 */
		private Node previous;
		private Object value;
		private Node next;
		
	}
	
	private Node sentinel;
	
	private HashMap map;
	
	private boolean isInLinkedList(Node node) {
		Node n = sentinel.next;
		while (n != sentinel) {
			if (n == node)
				return true;
			n = n.next;
		}
		return false;
	}
	
	public LinkedHashSet() {
		sentinel = new Node();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
		map = new HashMap(10);
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean contains(Object value) {
		return map.containsKey(value);
	}

	@Override
	public void add(Object value) {
		if(!inLinkedList(value)) {
			Node node = new Node();
			node.previous
		}
		
	}

	@Override
	public void remove(Object value) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
