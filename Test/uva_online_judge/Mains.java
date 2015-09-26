

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&
 * category=24&page=show_problem&problem=4460
 *
 * There is an objective test result such as ``OOXXOXXOOO". An `O' means a
 * correct answer of a problem and an `X' means a wrong answer. The score of
 * each problem of this test is calculated by itself and its just previous
 * consecutive `O's only when the answer is correct. For example, the score of
 * the 10th problem is 3 that is obtained by itself and its two previous
 * consecutive `O's.
 * 
 * Therefore, the score of
 * ``OOXXOXXOOO" is 10 which is calculated by ``1+2+0+0+1+0+0+1+2+3".
 * 
 * You are to write a program calculating the scores of test results.
 * 
 * Input
 * 
 * Your program is to read from standard input. The input consists of T test
 * cases. The number of test cases T is given in the first line of the input.
 * Each test case starts with a line containing a string composed by `O' and `X'
 * and the length of the string is more than 0 and less than 80. There is no
 * spaces between `O' and `X'.
 * 
 * Output
 * 
 * Your program is to write to standard output. Print exactly one line for each
 * test case. The line is to contain the score of the test case.
 * 
 * The following shows sample input and output for five test cases.
 * 
 * Sample Input
 * 
 * 5
 * OOXXOXXOOO
 * OOXXOOXXOO
 * OXOXOXOXOXOXOX
 * OOOOOOOOOO
 * OOOOXOOOOXOOOOX
 * 
 * Sample Output
 * 
 * 10
 * 9 
 * 7 
 * 55 
 * 30
 * 
 * @author neerajsi
 *
 */
public class Mains {

	public static void main(String[] args) {
		Mains myWork = new Mains();
		myWork.begin();
		

	}
	
	void begin() {
		Scanner scanner = new Scanner(System.in);
		int numOfTestCases = Integer.parseInt(scanner.nextLine());
		List<Integer> output = new ArrayList<>(numOfTestCases);
		int outputIndex=0;
		for (int i = 0; i < numOfTestCases; i++) {
			String answers = scanner.nextLine();

			int answerCount = answers.length();
			if (answers.length() > 80) {
				answerCount = 80;
			}
			
			if (answers.length() == 0) {
				answerCount =0;
			}
			int index = 0;
			
			int total = 0;
			int placeValue = 0;
			char previousAnswer = ' ';
			char answer = ' ';
			
			while (index < answerCount) {
				previousAnswer = answer;
				answer = answers.charAt(index);

				switch (answer) {

				case 'o':
					if (previousAnswer == ' ') {
						placeValue = 1;
					} else if (previousAnswer == 'o' && answer =='o') {
						placeValue = placeValue + 1;
					} else {
						placeValue = 1;
					}
					break;

				case 'x':
					placeValue = 0;

				}
				total = total + placeValue;
				index = index + 1;
			}
			output.add(outputIndex++, total);
			
			
		}//End TestCases
		for (int i=0; i<outputIndex; i++) {
			System.out.println (output.get(i));
		}
	}

	
}