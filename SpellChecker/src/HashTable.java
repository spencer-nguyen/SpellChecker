/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class creates a hash table...

************************************************************************/
public class HashTable {
	
	private LinkedList[] table;
	private int tableSize;
	
	HashTable(int tableSize){
		this.tableSize = tableSize;
		this.table = new LinkedList[tableSize];
		
		for (int i = 0; i < this.tableSize; i++) {
			this.table[i] = new LinkedList();
		}
		
	}
	
	public void insert(String key) {
		
		int bucket = hashMultiplicative(key);

		this.table[bucket].prepend(key);
		
	}
	
	public boolean search(String key) {
		
		int bucket = hashMultiplicative(key);
		
		return this.table[bucket].search(key);
	}
	
	private int hashMultiplicative(String key){
		
		int stringHash     = 5381;
		int hashMultiplier = 33;
		
		for(int i = 0; i < key.length(); i++) {
			stringHash += (stringHash * hashMultiplier) + (int)key.charAt(i);
		}
		
		return Math.abs(stringHash % this.tableSize);
	}
	
	
	
	
	
}