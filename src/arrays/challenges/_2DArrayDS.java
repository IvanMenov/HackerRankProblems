package arrays.challenges;

import java.util.Scanner;

public class _2DArrayDS {

	private static final Scanner scanner = new Scanner(System.in);

	private static int hourglassSum(int[][] arr) {
		int firstEl = 0;
		int secEl =0;
		int thirdEl = 0;
		int fourthEl =0;
		int fifthEl =0;
		int sixthEl = 0;
		int seventhEl =0;
		
		int currentValue= 0;
		int maxValue = Integer.MIN_VALUE;
		
		for (int row = 0; row < arr.length-2; row++) {
			for (int col = 0; col < arr[row].length-2; col++) {
				firstEl = arr[row][col];
				secEl = arr[row][col+1];
				thirdEl = arr[row][col +2];
				fourthEl = arr[row+1][col+1];
				fifthEl = arr[row+2][col];
				sixthEl = arr[row+2][col+1];
				seventhEl = arr[row+2][col+2];
				currentValue = firstEl + secEl + thirdEl + fourthEl + fifthEl + sixthEl + seventhEl;
				
				if(currentValue > maxValue) {
					maxValue = currentValue;
				}
				
			}
		}

		return maxValue;
	}
	
    public static void main(String[] args)  {
      

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        scanner.close();
        
        int result = hourglassSum(arr);

       System.out.println(result);

       
    }

	

}
