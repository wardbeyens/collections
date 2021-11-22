package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MapTest {

	void testMap(Map map) {
		assertEquals(0, map.entrySet().size());
		
		map.put("key1", 1);
		assertEquals(1, map.get("key1"));
		assertEquals(1, map.entrySet().size());
		
		map.put("key1", 2);
		assertEquals(2, map.get("key1"));
		assertEquals(1, map.entrySet().size());

		map.put("key2", false);
		assertEquals(false, map.get("key2"));
		assertEquals(2, map.entrySet().size());

		map.remove("key2");
		assertEquals(1, map.entrySet().size());
		
		assertEquals(null, map.get("ikbestanie"));
	}

	@Test
	void testArrayMap() {
		testMap(new ArrayMap()); 
	}
	
	@Test
	void testLinkedMap() {
		testMap(new HashMap(5));
	}

}
