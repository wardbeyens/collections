package collections;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedHashSetTest {

	@Test
	void test() {
		LinkedHashSet set = new LinkedHashSet();
		set.add(30);
		set.add(20);
		set.add(10);
		assertArrayEquals(new Object[] {30, 20, 10}, set.toArray());
		assertTrue(set.contains(30));
		assertTrue(set.contains(20));
		assertTrue(set.contains(10));
		assertFalse(set.contains(40));
		
		set.remove(20);
		assertArrayEquals(new Object[] {30, 10}, set.toArray());
		assertTrue(set.contains(30));
		assertFalse(set.contains(20));
		assertTrue(set.contains(10));
		assertFalse(set.contains(40));
		
		set.remove(20);
		assertArrayEquals(new Object[] {30, 10}, set.toArray());
		assertTrue(set.contains(30));
		assertFalse(set.contains(20));
		assertTrue(set.contains(10));
		assertFalse(set.contains(40));
		
		set.add(20);
		assertArrayEquals(new Object[] {30, 10, 20}, set.toArray());
		assertTrue(set.contains(30));
		assertTrue(set.contains(20));
		assertTrue(set.contains(10));
		assertFalse(set.contains(40));
	}

}
