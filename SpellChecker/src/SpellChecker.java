import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class creates a hash table...

************************************************************************/
public class SpellChecker {
	
	private final int HASH_TABLE_SIZE = 100000;

	private String dictionaryTxt = "dictionary.txt";
	private String fileToCheck;
	
	HashTable dictionary;
	
	SpellChecker(String fileToCheck) throws FileNotFoundException{
		
		this.fileToCheck = fileToCheck;
		
		this.dictionary = new HashTable(HASH_TABLE_SIZE);
		
		buildDictionary();
		
	}
	
	private void buildDictionary() throws FileNotFoundException {
				
		File file = new File(dictionaryTxt);
		Scanner scnr = new Scanner(file);
		
		while(scnr.hasNextLine()) {
			
			this.dictionary.insert(scnr.nextLine().toLowerCase());
		}
		scnr.close();
	}
	

	
}
