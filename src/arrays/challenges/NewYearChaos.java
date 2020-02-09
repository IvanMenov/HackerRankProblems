package arrays.challenges;

import java.util.Scanner;

public class NewYearChaos {

	private static Scanner scanner = new Scanner(System.in);
	// Complete the minimumBribes function below.
	private static final int maxBribes = 2;

	static void minimumBribes(int[] q) {
		int result = 0;
		int initialNumberInQueue = 0;

		for (int index = 0; index < q.length; index++) {
			initialNumberInQueue++;
			int actualNumber = q[index];

			int resultSubtraction = actualNumber - initialNumberInQueue;
			if (resultSubtraction == 0) {
				continue;
			}
			if (resultSubtraction > 2 || resultSubtraction < -2) {
				System.out.println("Too chaotic");
				break;
			} else {
				result += Math.abs(resultSubtraction);
				swapElements(q, actualNumber, index, resultSubtraction);
			}
		}
		System.out.println(result);

	}

	/*
	 * 1 2 5 3 4 7 8 6 -1 2 3 4 5 6 7 8
	 */

	private static void swapElements(int[] q, int actualNumber, int indexActualNumber, int resultSubtraction) {
		if (resultSubtraction == 1 || resultSubtraction == -1) {
			q[indexActualNumber] = q[++indexActualNumber];
			q[indexActualNumber] = actualNumber;
		} else {
			if (indexActualNumber == q.length - 1) {

				int indexMoved = indexActualNumber + resultSubtraction;
				int temp = q[indexMoved];
				q[indexMoved] = actualNumber;
				q[indexActualNumber] = temp;
			}else{
				for (int i = 0; i < maxBribes; i++) {
					q[indexActualNumber] = q[++indexActualNumber];
				}
				q[indexActualNumber] = actualNumber;	
			}
			
		}

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
