import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void test() {
		
		HashTable test = new HashTable(10);
		
		assertEquals(183058, test.hashMultiplicative("h"));


		
	}

}
