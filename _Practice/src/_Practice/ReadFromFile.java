package _Practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader("/Users/neerajsingh/Documents/workspace/_InterviewPractice/src/_InterviewPractice/test.txt");
		BufferedReader buffReader = new BufferedReader(fileReader);
		
		String line;
		while ((line = buffReader.readLine() )!= null) {
			System.out.println(line);
		}
	}
}
