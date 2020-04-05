package practice;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/*John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock
Input Format

The first line contains an integer , the number of socks represented in .
The second line contains  space-separated integers describing the colors  of the socks in the pile.

Constraints

 where 
Output Format

Return the total number of matching pairs of socks that John can sell.

Sample Input

9
10 20 20 10 10 30 50 10 20
Sample Output

3*/

public class HackerRankSockProblem {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] myArray) {

       Map<Integer, Long> collect = Arrays.stream(myArray).boxed().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        
        System.out.println(collect);
        Map<Object, List<Integer>> collect2 = collect.keySet().stream()
                .filter(k-> ((collect.get(k) >1) && (collect.get(k) % 2) >=0) )
                .collect(Collectors.groupingBy(k -> ((long)collect.get(k))/2));

        System.out.println("count " + collect2);
        Long count = collect2.keySet().stream().map(k->  (collect2.get(k)).size() * (long) k).collect(Collectors.summingLong(k->k));
        System.out.println(count);
        return count.intValue();
    }


    public static void main(String[] args) throws IOException {

    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Enter no of elements, and start entering elements");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        scanner.close();
    }
}
