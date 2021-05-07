/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class creates a hash table of strings using external chaining for
collision management.

************************************************************************/
public class HashTable {
	
	private int tableSize;
	
	private LinkedList[] table;
		
	HashTable(int tableSize){
		this.tableSize = tableSize;
		this.table     = new LinkedList[tableSize];
		
		/* Construct LinkedList for each bucket. */
		for (int i = 0; i < this.tableSize; i++) {
			this.table[i] = new LinkedList();
		}
	}
	
	/**
	 * This method inserts the key into the corresponding bucket.
	 * @param key
	 */
	public void insert(String key) {
		int bucket = hashMultiplicative(key);
		this.table[bucket].prepend(key);	
	}
	
	/**
	 * This method searches the bucket LinkedList for the key.
	 * @param key
	 * @return
	 */
	public boolean search(String key) {
		int bucket = hashMultiplicative(key);
		return this.table[bucket].search(key);
	}
	
	/**
	 * This is the hash function that maps the key (string) to the bucket.
	 * This function utilizes Bertstein's Hash Function.
	 * @param key
	 * @return
	 */
	private int hashMultiplicative(String key){
		/* Berstein's Hash Function Values */
		int stringHash     = 5381;
		int hashMultiplier = 33;
		
		for(int i = 0; i < key.length(); i++) {
			stringHash += (stringHash * hashMultiplier) + (int)key.charAt(i);
		}
		return Math.abs(stringHash % this.tableSize);
	}
}