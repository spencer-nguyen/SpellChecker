import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void test() {
		
		HashTable test = new HashTable(10);
		
		test.insert("hello");
		test.insert("yellow");
		test.insert("olleh");
		
		assertEquals(true, test.search("hello"));
		assertEquals(true, test.search("yellow"));
		assertEquals(true, test.search("olleh"));



	}

}
