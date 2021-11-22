package collections;

import java.util.Arrays;

public class LinkedHashSet implements Set {
	
	private class Node {
		/**
		 * @invar | previous != null
		 * @invar | next != null
		 * @invar | previous.next == this
		 * @invar | next.previous == this
		 * @invar | this == sentinel || map.get(value) == this
		 * 
		 * @peerObject
		 */
		private Node previous;
		private Object value;
		/**
		 * @peerObject
		 */
		private Node next;
	}
	
	private boolean isInLinkedList(Node node) {
		Node n = sentinel.next;
		while (n != sentinel) {
			if (n == node)
				return true;
			n = n.next;
		}
		return false;
	}
	
	/**
	 * @representationObject
	 */
	private Node sentinel;
	/**
	 * @invar | map != null
	 * @invar | Arrays.stream(map.entrySet().toArray()).allMatch(e ->
	 *        |     ((Map.Entry)e).getValue() instanceof Node &&
	 *        |     isInLinkedList((Node)((Map.Entry)e).getValue()) &&
	 *        |     ((Node)((Map.Entry)e).getValue()).value == ((Map.Entry)e).getKey())
	 * @representationObject
	 */
	private HashMap map;
	
	public LinkedHashSet() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
		map = new HashMap();
	}
	
	@Override
	public Object[] toArray() {
		Object[] result = new Object[map.size()];
		Node n = sentinel.next;
		for (int i = 0; i < result.length; i++) {
			result[i] = n.value;
			n = n.next;
		}
		return result;
	}
	
	@Override
	public int size() {
		return map.size();
	}
	
	@Override
	public boolean contains(Object object) {
		return map.containsKey(object);
	}
	
	@Override
	public void add(Object object) {
		if (!map.containsKey(object)) {
			Node n = new Node();
			n.value = object;
			n.next = sentinel;
			n.previous = sentinel.previous;
			sentinel.previous = n;
			n.previous.next = n;
			map.put(object, n);
		}
	}
	
	@Override
	public void remove(Object object) {
		Node n = (Node)map.get(object);
		if (n != null) {
			map.remove(object);
			n.previous.next = n.next;
			n.next.previous = n.previous;
		}
	}

}
