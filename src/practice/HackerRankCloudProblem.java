package practice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.naming.spi.DirStateFactory.Result;

/*Emma is playing a new mobile game that starts with consecutively numbered clouds.
 *  Some of the clouds are thunderheads and others are cumulus. 
 *  She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . 
 *  She must avoid the thunderheads. 
 *  Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud.
 *   It is always possible to win the game.

For each game, Emma will get an array of clouds numbered  if they are safe or  if they must be avoided. For example,  indexed from .
 The number on each cloud is its index in the list so she must avoid the clouds at indexes  and . 
 She could follow the following two paths:  or . The first path takes  jumps while the second takes .

Function Description

Complete the jumpingOnClouds function in the editor below. It should return the minimum number of jumps required, as an integer.

jumpingOnClouds has the following parameter(s):

c: an array of binary integers
Input Format

The first line contains an integer , the total number of clouds. 
The second line contains  space-separated binary integers describing clouds  where .

Constraints

Output Format

Print the minimum number of jumps needed to win the game.

Sample Input 0

7
0 0 1 0 0 1 0
Sample Output 0

4
Explanation 0:
Emma must avoid  and . She can win the game with a minimum of  jumps:

jump(2).png

Sample Input 1

6
0 0 0 0 1 0
Sample Output 1

3

*/

public class HackerRankCloudProblem {

	static List<List<Integer>> listIn = new ArrayList<>();
	


    public static void main(String[] args) throws IOException {

    	Scanner scanner = new Scanner(System.in);
    	
    	
    	System.out.println("Enter no of elements, and start entering elements");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(arItems[i]);
            arr[i] = cItem;
        }

        jumpingOnClouds(n,arr);

        scanner.close();
    }


	private static Integer jumpingOnClouds(int n, int[] arr) {
		Integer counter = 0;
		
		 Arrays.stream(arr).boxed().reduce(0,(oldv,newv)->{
			 System.out.println(oldv + " " + newv);
			 if(oldv == 0 && newv==0 && listIn.isEmpty()) {
				 listIn.add(new ArrayList<>());
				 listIn.get(listIn.size()-1).add(newv);
				 return oldv+newv;
			 }
			 if(oldv == 1 && newv==0) {
				 listIn.add(new ArrayList<>());
				 listIn.get(listIn.size()-1).add(newv);
				 oldv=0;
				 return oldv;
			 }
			 if(oldv == 0 && newv==0 && !listIn.isEmpty()) {
				 listIn.get(listIn.size()-1).add(newv);
			 }
			 return oldv+newv;
			 
		 });
		 
		 counter = counter + listIn.size()-1;
		 
		 Map<Integer, List<List<Integer>>> collect = listIn.parallelStream().collect(Collectors.groupingBy(x->x.size()));
		 
		 for (Iterator iterator = listIn.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			counter = counter + (list.size() / 2);
			
		}
		 
		 System.out.println(counter);
		 
		 return counter;
		
	}



}
