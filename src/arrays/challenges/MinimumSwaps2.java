package arrays.challenges;

import java.util.Scanner;

public class MinimumSwaps2 {

	private static Scanner scanner = new Scanner(System.in);

	private static int minimumSwaps(int[] arr) {

		int minValue = arr[0];
		int swaps = 0;
		int i = 0;

		for (int index = 0; index < arr.length; index++) {
			if (arr[index] < minValue) {
				minValue = arr[index];
			}

		}
		while (i < arr.length) {
			int finalIndexOfCurrentElement = arr[i] - minValue;
			if (finalIndexOfCurrentElement != i) {
				swapElements(finalIndexOfCurrentElement, i, arr);
				swaps++;
			} else {
				i++;
			}
		}
		return swaps;

	}

	private static void swapElements(int finalIndexOfCurrentElement, int i, int[] arr) {
		int temp = arr[finalIndexOfCurrentElement];
		arr[finalIndexOfCurrentElement] = arr[i];
		arr[i] = temp;

	}

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);
		System.out.println(res);

		scanner.close();
	}

}
