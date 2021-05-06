/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class creates a hash table...

************************************************************************/
public class HashTable {
	
	private String[] table;
	private int tableSize;
	
	HashTable(int tableSize){
		this.tableSize = tableSize;
		table = new String[tableSize];
		
	}
	
	public void insert(String key) {
		
		int bucket = hashMultiplicative(key) % this.tableSize;
		
		if(this.table[bucket] == null) {
			this.table[bucket] = key;
		}
		
		
	}
	
	private int hashMultiplicative(String key){
		
		int stringHash     = 5381;
		int hashMultiplier = 33;
		
		for(int i = 0; i < key.length(); i++) {
			stringHash += (stringHash * hashMultiplier) + (int)key.charAt(i);
			System.out.println(i);
		}
		
		return stringHash;
	}
	
	
	
	
	
}