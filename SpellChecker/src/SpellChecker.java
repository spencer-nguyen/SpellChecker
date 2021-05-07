/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class creates a hash table...

************************************************************************/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SpellChecker {
	
	private final int HASH_TABLE_SIZE = 100000;

	private String dictionaryTxt;
	private String fileToCheck;
	private ArrayList<String> suggestedWords;
	
	private HashTable dictionary;
	
	SpellChecker(String fileToCheck) throws FileNotFoundException{
		
		this.suggestedWords = new ArrayList<String>();
		this.dictionaryTxt = "dictionary.txt";
		this.fileToCheck = fileToCheck;
		
		this.dictionary = new HashTable(HASH_TABLE_SIZE);
		
		buildDictionary();
				
		spellCheckFile();
	}
	
	private void buildDictionary() throws FileNotFoundException {
				
		File file = new File(dictionaryTxt);
		Scanner scnr = new Scanner(file);
		
		while(scnr.hasNextLine()) {
			
			this.dictionary.insert(scnr.nextLine().toLowerCase());
		}
		scnr.close();
	}
	
	private void printOriginalText() throws FileNotFoundException {
		File file = new File(this.fileToCheck);
		Scanner scnr = new Scanner(file);
		
		System.out.println("------------Original Text------------");
		while(scnr.hasNextLine()) {
			System.out.println(scnr.nextLine());
		}
		scnr.close();
	}
	
	private void spellCheckFile() throws FileNotFoundException {

		String word;
		File file = new File(this.fileToCheck);
		Scanner scnr = new Scanner(file).useDelimiter("[ ,!?.]+");
		
		printOriginalText();
		
		System.out.println("\n------------Suggested Corrections------------");

		while(scnr.hasNext()) {
			this.suggestedWords.clear();
			
			word = scnr.next();
			
			if(wordIsInDictionary(word) == false) {
				addLetterCheck(word);
				deleteLetterCheck(word);
				swapLetterCheck(word);
				
				System.out.print(word + " : ");
				
				if(this.suggestedWords.isEmpty()) {
					System.out.print("no suggestions \n");
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
				}
				System.out.println();
			}
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
				
				if(this.dictionary.search(addLetterWord) && this.suggestedWords.contains(addLetterWord) == false) {
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
			
			if(this.dictionary.search(deleteLetterWord) && this.suggestedWords.contains(deleteLetterWord) == false) {
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
			
			if(this.dictionary.search(swapLetterWord) && this.suggestedWords.contains(swapLetterWord) == false) {
				this.suggestedWords.add(swapLetterWord);
			}
		}	
	}
}
