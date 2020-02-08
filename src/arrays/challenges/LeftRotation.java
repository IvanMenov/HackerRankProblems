package arrays.challenges;

import java.io.IOException;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class LeftRotation {
	 // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
		int []result = new int[a.length];
		int lengthArray = a.length;
		int tempIndex = 0;
		
		for (int index = 0; index < a.length; index++) {
			int subtraction = index - d;
			if(subtraction < 0){
				tempIndex = lengthArray + subtraction;
				result[tempIndex] = a[index];
			}
			else{
				result[subtraction] = a[index];
			}
		}
		return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        scanner.close();
        
        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
           System.out.print(result[i]+" ");
        }
        
    }
}
