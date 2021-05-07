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
	
	private HashTable dictionary;
	
	SpellChecker(String fileToCheck) throws FileNotFoundException{
		
		this.fileToCheck = fileToCheck;
		
		this.dictionary = new HashTable(HASH_TABLE_SIZE);
		
		buildDictionary();
		
		deleteLetterCheck("pool");
		
	}
	
	private void buildDictionary() throws FileNotFoundException {
				
		File file = new File(dictionaryTxt);
		Scanner scnr = new Scanner(file);
		
		while(scnr.hasNextLine()) {
			
			this.dictionary.insert(scnr.nextLine().toLowerCase());
		}
		scnr.close();
	}
	
	private boolean wordIsInDictionary(String word) {
		word = word.toLowerCase();
		return this.dictionary.search(word);
	}
	
	private void addLetterCheck(String word) {
		word = word.toLowerCase();
		
		String addLetterWord = "";

		for(int i = 0; i < word.length() + 1; i++) {

			for(int j = (int)'a'; j < (int)'z' + 1; j++) {
					
				if(i == 0) {
					addLetterWord = (char)j + word.substring(i);
				}
					
				else {
					addLetterWord = word.substring(0, i) + (char)j + word.substring(i, word.length());
				}
				
				

			}
		}	
	}
	
	private void deleteLetterCheck(String word) {
		
		word = word.toLowerCase();
		
		String deleteLetterWord = "";
		
		for(int i = 0; i < word.length(); i++) {
			
			if(i == 0) {
				deleteLetterWord = word.substring(i + 1);
			}
			else {
				deleteLetterWord = word.substring(0, i) + word.substring(i + 1);
			}
			
			System.out.println(deleteLetterWord);
		}	
		
		
		
		
	}
	
	
	
	
	
	
	
}
