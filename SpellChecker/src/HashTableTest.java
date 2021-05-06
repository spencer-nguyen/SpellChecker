import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void test() throws FileNotFoundException {
		
		SpellChecker test = new SpellChecker("test");
		
		assertEquals(true,test.dictionary.search("abaft"));
		

		

	}

}
