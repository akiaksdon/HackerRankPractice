package practice;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography. During his last hike he took exactly  steps. For every step he took, he noted if it was an uphill, , or a downhill,  step. Gary's hikes start and end at sea level and each step up or down represents a  unit change in altitude. We define the following terms:

A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

For example, if Gary's path is , he first enters a valley  units deep. Then he climbs out an up onto a mountain  units high. Finally, he returns to sea level and ends his hike.

Function Description

Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.

countingValleys has the following parameter(s):

n: the number of steps Gary takes
s: a string describing his path
Input Format

The first line contains an integer , the number of steps in Gary's hike.
The second line contains a single string , of  characters that describe his path.

Constraints

Output Format

Print a single integer that denotes the number of valleys Gary walked through during his hike.

Sample Input

8
UDDDUDUU
Sample Output

1
Explanation

If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:

_/\      _
   \    /
    \/\/
He enters and leaves one valley.
*/

public class HackerRankTwoDArrayProblem {
	

	static List<HourGlass> hourGlassList = new ArrayList<HourGlass>();

    


	public static void main(String[] args) throws IOException {

		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * System.out.println(" start entering elements"); int[][] arr = new int[6][6];
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * 
		 * for (int i = 0; i < 6; i++) { String[] arrRowItems =
		 * scanner.nextLine().split(" ");
		 * scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		 * 
		 * for (int j = 0; j < 6; j++) { int arrItem = Integer.parseInt(arrRowItems[j]);
		 * arr[i][j] = arrItem; } }
		 */
        
    	int[][] arr2 = { {1,1,1,0,0,0},
    					 {0,1,0,0,0,0},
    					 {1,1,1,0,0,0},
    					 {0,0,2,4,4,0},
    					 {0,0,0,2,0,0},
    					 {0,0,1,2,4,0}
    				};

        
        
        int result = hourglassSum(arr2);

//        scanner.close();
    }


	private static int hourglassSum(int[][] arr) {
		// TODO Auto-generated method stub
		
		
		for (int row = 0; row < 4; row++) {
			int row2 = row +1;
			int row3 = row +2;
			
            for (int col = 0; col < 4; col++) {
            	
            	HourGlass hourGlass = new HourGlass();
            	List<Integer> top = new ArrayList<>();
            	List<Integer> bottom = new ArrayList<>();
       
            	int mid = Integer.MIN_VALUE;
            	    int newcnt = col;
            	    int n = col;
            	    
            		for(int cnt =0 ; cnt <3 ; cnt ++) {
            			top.add(cnt, arr[row][newcnt]);
            			
            			if(newcnt  % 2 != 0 && n % 2 ==0)
            			    mid = arr[row2][newcnt];
            			else if(newcnt  % 2 == 0 && n % 2 !=0 )
            				mid = arr[row2][newcnt];
            			
            			
            			bottom.add(cnt, arr[row3][newcnt]);
            			
            			newcnt++;
            		}
            		hourGlass.setTop(top);
            		hourGlass.setMid(mid);
            		hourGlass.setBottom(bottom);
            	           
            	HackerRankValleyProblem.hourGlassList.add(hourGlass);
            	
            }
        }

		OptionalInt sum = HackerRankValleyProblem.hourGlassList.parallelStream().mapToInt(x->x.sum()).max();
		
		System.out.println(sum.getAsInt());
		
		
		
		
		return sum.getAsInt();
	}


	@Override
	public String toString() {
		return "HackerRankTwoDArrayProblem []";
	}

	
}

class HourGlass {
	
	List<Integer> top = new ArrayList<>();
	Integer mid ;
	List<Integer> bottom = new ArrayList<>();
	
	public List<Integer> getTop() {
		return top;
	}
	public void setTop(List<Integer> top) {
		this.top = top;
	}
	public Integer getMid() {
		return mid;
	}
	@Override
	public String toString() {
		return "HourGlass [top=" + top + ", mid=" + mid + ", bottom=" + bottom + "]";
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public List<Integer> getBottom() {
		return bottom;
	}
	public void setBottom(List<Integer> bottom) {
		this.bottom = bottom;
	}
	
	public Integer sum() {
		
		Integer topSum = getTop().parallelStream().mapToInt(x->x.intValue()).sum();
		Integer botSum = getBottom().parallelStream().mapToInt(x->x.intValue()).sum();
		return topSum + getMid() + botSum;
		
	}
}
