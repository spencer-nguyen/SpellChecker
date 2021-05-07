import java.io.FileNotFoundException;

/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class creates a hash table...

************************************************************************/
public class main {

	public static void main(String[] args) throws FileNotFoundException {
		
		String fileToCheck = "testTextFile.txt";
		
		SpellChecker splchk = new SpellChecker(fileToCheck);
	}
}
