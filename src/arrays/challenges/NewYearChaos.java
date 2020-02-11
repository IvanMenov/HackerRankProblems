package arrays.challenges;

import java.util.Scanner;

public class NewYearChaos {

	private static Scanner scanner = new Scanner(System.in);
	// Complete the minimumBribes function below.

	static void minimumBribes(int[] q) {
		int result = 0;
		int expectedNumber = 0;
		int actualNumber  = 0;
		int temp = 0;
		for (int index = q.length-1; index >=0 ; index--) {
			actualNumber = q[index];
			expectedNumber = index +1;
			int subtraction = actualNumber - expectedNumber;
			if(subtraction> 2) {
				System.out.println("Too chaotic");
				return;
			}
			else {
				if(subtraction == 2) {
					temp = q[index];
					result += subtraction;
					for(int i = index ; i< index +3; i ++) {
						if(i == index +2) {
							q[i] = temp;
						}else {
							int tempIndex = i+1;
							q[i] = q[tempIndex];
						}
						
					}
					index++;
					
				}
				if(subtraction == 1) {
					result += subtraction;
					temp = q[index];
					int nextIndex = index +1 ;
					q[index]  = q[nextIndex];
					q[nextIndex] = temp;
					index++;
				}
				
			}
	
		}
		System.out.println(result);
		return;
		
	}

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			 minimumBribes(q);
			
		}

		scanner.close();
	}

}
