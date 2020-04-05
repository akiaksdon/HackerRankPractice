package practice;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*Lilah has a string, , of lowercase English letters that she repeated infinitely many times.

Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.

For example, if the string  and , the substring we consider is , the first  characters of her infinite string. There are  occurrences of a in the substring.

Function Description

Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.

repeatedString has the following parameter(s):

s: a string to repeat
n: the number of characters to consider
Input Format

The first line contains a single string, .
The second line contains an integer, .

Constraints

For  of the test cases, .
Output Format

Print a single integer denoting the number of letter a's in the first  letters of the infinite string created by repeating  infinitely many times.

Sample Input 0

aba
10
Sample Output 0

7
Explanation 0
The first  letters of the infinite string are abaabaabaa. Because there are  a's, we print  on a new line.

Sample Input 1

a
1000000000000
Sample Output 1

1000000000000
Explanation 1
Because all of the first  letters of the infinite string are a, we print  on a new line.

*/

public class HackerRankRepeatedStringProblem {

	


	private static long repeatedString(String requiredString, Long n) {
		
		long aCount = requiredString.chars().map(x -> (char) x).filter(x -> x == 'a').count();
		
		//calculate char required  factor   [ length of streing (X) countof a in given string ] 
		BigDecimal requiredFactor = BigDecimal.valueOf((double) n / (double) requiredString.length()).setScale(2,RoundingMode.HALF_UP);
		String doubleAsString = String.valueOf(requiredFactor);
		
		//calculating small required a for remaining string after calculating factor
		int indexOfDecimal = doubleAsString.indexOf(".");
		String quotient = doubleAsString.substring(0, indexOfDecimal);
		Long qvalue = Long.valueOf(quotient);
		String remainder = doubleAsString.substring(indexOfDecimal);
		Double valueOf = Double.valueOf(remainder);
		
		//minutely calculated a count 
		double minutelyClculatedAcount = ((double) valueOf * (float) requiredString.length());
		long roundedMinutelyClculatedAcount = Math.round(minutelyClculatedAcount);
		
		//total before adding minutely calculated a count
		long tot = aCount * qvalue;
		
		//actually counting minutely calculated a count
		for (int i = 0; i < roundedMinutelyClculatedAcount; i++) {
			if(requiredString.charAt(i) == 'a')
				tot++;
			
		}
		
		//returning count
		return tot;
		
		
	}


    public static void main(String[] args) throws IOException {

    	Scanner scanner = new Scanner(System.in);
    	
    	
    	System.out.println("Enter no of repeating string and string ");
        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

  

       long result = repeatedString(s, n);
       
       System.out.println(result);

        scanner.close();
    }


	



}
