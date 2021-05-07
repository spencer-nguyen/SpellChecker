/*********************************************************************** 
  Student Name: Spencer Nguyen
  File Name: SpellChecker
  Assignment Number: Project 4
  Course: COP5416

This class is the main class for the spell checker. It accepts the
test text file as input to be checked.
************************************************************************/
import java.io.FileNotFoundException;

public class main {

	public static void main(String[] args) throws FileNotFoundException {
		String fileToCheck = "testTextFile.txt";
		SpellChecker splchk = new SpellChecker(fileToCheck);
	}
}
