package example;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class SetTest {

		void testSet(Set set) {
			assertEquals(0, set.size());
			
			set.add(7);
			assertTrue(set.contains(7));
			assertFalse(set.contains(0));
			assertEquals(1, set.size());
			
			Object[] objectArray = {7};
			assertTrue(Arrays.equals(objectArray, set.toArray()));

			set.add(42);
			assertEquals(2, set.size());
			assertTrue(set.contains(7));
			assertTrue(set.contains(42));
			
			set.add(42);
			assertEquals(2, set.size());
			assertTrue(set.contains(7));
			assertTrue(set.contains(42));
			
			set.remove(0);
			assertEquals(2, set.size());
			assertTrue(set.contains(7));
			assertTrue(set.contains(42));

			set.remove(42);
			assertEquals(1, set.size());
			assertTrue(set.contains(7));
			assertFalse(set.contains(42));

			set.add("a");
			set.add("b");
			set.add(5555);
			set.add(55555);
			set.add("b");
			set.add("b");
			set.add("c");
			set.add("d");
			set.add("e");
			set.add("f");
			//assertFalse(1, set.size());
		}

		@Test
		void testArraySet() {
			testSet(new ArraySet()); 
		}
		
		@Test
		void testHahSet() {
			testSet(new HashSet(3));
		}

	}