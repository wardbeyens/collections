import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListTest {

	void testList(List list) {
		assertEquals(0, list.size());
		
		list.add(0, 7);
		assertTrue(list.contains(7));
		assertFalse(list.contains(0));
		assertEquals(1, list.size());
		assertEquals(7, list.get(0));
		
		list.add(0, 42);
		assertEquals(2, list.size());
		assertEquals(42, list.get(0));
		assertEquals(7, list.get(1));
		
		list.remove(0);
		assertEquals(1, list.size());
		assertEquals(7, list.get(0));

		list.add(1, 42);
		assertEquals(2, list.size());
		assertEquals(7, list.get(0));
		assertEquals(42, list.get(1));

		list.remove(1);
		assertEquals(1, list.size());
		assertEquals(7, list.get(0));

		list.remove(0);
		assertEquals(0, list.size());
		
		list.add("a");
		list.add("b");
		list.add(5555);
		list.add(55555);
		list.add("b");
		list.add("b");
		list.add("c");
		assertEquals(55555, list.get(3));
		list.remove("c");
		assertFalse(list.contains("c"));
	}

	@Test
	void testArrayIntList() {
		testList(new ArrayList()); 
	}
	
	@Test
	void testLinkedIntList() {
		testList(new LinkedList());
	}

}
