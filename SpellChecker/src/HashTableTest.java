import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class HashTableTest {

	@Test
	void test() throws FileNotFoundException {
		
		SpellChecker test = new SpellChecker("test");
		
		assertEquals(true, test.dictionary.search("taut"));
		assertEquals(true, test.dictionary.search("yellow"));
		assertEquals(true, test.dictionary.search("tan"));
		assertEquals(true, test.dictionary.search("cat"));
		assertEquals(true, test.dictionary.search("breed"));
		assertEquals(false, test.dictionary.search("tpe"));


	}

}
