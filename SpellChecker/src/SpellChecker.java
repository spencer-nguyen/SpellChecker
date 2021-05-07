/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class accepts a txt file containing the dictionary and a txt file
to check word spelling. 

The spell check is not case sensitive and checks for the following conditions:
	1. Missing Letter
	2. Additional Letter
	3. Swapped Letters
************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {
	
	private final int HASH_TABLE_SIZE = 100000;// this size is set such that the load factor is near 0.75

	private String dictionaryTxt;
	private String fileToCheck;
	
	private ArrayList<String> suggestedWords;
	
	private HashTable dictionary;
	
	SpellChecker(String fileToCheck) throws FileNotFoundException{
		this.suggestedWords = new ArrayList<String>();
		this.dictionary     = new HashTable(HASH_TABLE_SIZE);
		this.dictionaryTxt  = "dictionary.txt";
		this.fileToCheck    = fileToCheck;
		
		buildDictionary();		
		spellCheckFile();
	}
	
	/**
	 * This method builds the dictionary from a txt file
	 * into a hash table using external chaining for collision
	 * management.
	 * @throws FileNotFoundException
	 */
	private void buildDictionary() throws FileNotFoundException {
		File file    = new File(dictionaryTxt);
		Scanner scnr = new Scanner(file);
		
		while(scnr.hasNextLine()) {
			this.dictionary.insert(scnr.nextLine().toLowerCase());// words are inserted and checked as lower case
		}
		scnr.close();
	}
	
	/**
	 * This method prints the original input text that is to be spell checked.
	 * @throws FileNotFoundException
	 */
	private void printOriginalText() throws FileNotFoundException {
		File file    = new File(this.fileToCheck);
		Scanner scnr = new Scanner(file);
		
		System.out.println("------------Original Text------------");
		while(scnr.hasNextLine()) {
			System.out.println(scnr.nextLine());
		}
		scnr.close();
	}
	
	/**
	 * This method analyzes each string in the text and determines if it is 
	 * spelled correctly or incorrectly. If it is spelled incorrectly, suggested words
	 * are placed in an ArrayList and printed out.
	 * @throws FileNotFoundException
	 */
	private void spellCheckFile() throws FileNotFoundException {
		String word;
		
		File file    = new File(this.fileToCheck);
		Scanner scnr = new Scanner(file).useDelimiter("[ ,!?.]+");
		
		printOriginalText();
		
		System.out.println("\n------------Suggested Corrections------------");

		while(scnr.hasNext()) {
			
			word = scnr.next();
						
			if(wordIsInDictionary(word) == false) {
				addLetterCheck(word);
				deleteLetterCheck(word);
				swapLetterCheck(word);
				
				System.out.print(word + " : ");
				
				if(this.suggestedWords.isEmpty()) {
					System.out.println("no suggestions");
				}
				else {
					for(int i = 0; i < this.suggestedWords.size(); i++) {
						if(i == this.suggestedWords.size() - 1) {
							System.out.print(this.suggestedWords.get(i));
						}
						else {
							System.out.print(this.suggestedWords.get(i) + ", ");
						}
					}
					System.out.println();
				}
			}
			this.suggestedWords.clear();
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
				
				if(this.dictionary.search(addLetterWord) == true && this.suggestedWords.contains(addLetterWord) == false) {
					this.suggestedWords.add(addLetterWord);
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
			
			if(this.dictionary.search(deleteLetterWord) == true && this.suggestedWords.contains(deleteLetterWord) == false) {
				this.suggestedWords.add(deleteLetterWord);
			}
		}	
	}
	
	private void swapLetterCheck(String word) {
		
		word = word.toLowerCase();
		char[] wordCharArr;
		char temp;
		String swapLetterWord;
		
		for(int i = 0; i < word.length() - 1; i++) {
			wordCharArr = word.toCharArray();
			temp = wordCharArr[i];
			wordCharArr[i] = wordCharArr[i + 1];
			wordCharArr[i + 1] = temp;
			
			swapLetterWord = new String(wordCharArr);
			
			if(this.dictionary.search(swapLetterWord) == true && this.suggestedWords.contains(swapLetterWord) == false) {
				this.suggestedWords.add(swapLetterWord);
			}
		}	
	}
}
