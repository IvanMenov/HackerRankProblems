package warmup.challenges;

import java.util.Scanner;

public class CountingValleys {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String s = scanner.nextLine();

		int result = countingValleys(n, s);

		System.out.println(result);
		scanner.close();

	}

	public static int countingValleys(int n, String s) {
		int result = 0;
		boolean didStartDownhill = false;
		boolean isSeaLevel = true;
		
		int upHillUnits = 0;
		int downHillUnits = 0;
		char[] array = s.toCharArray();

		for (int index = 0; index < array.length; index++) {
			if (array[index] == 'D') {
				downHillUnits++;
				if (downHillUnits == upHillUnits && downHillUnits != 0) {
					isSeaLevel = true;
					
				}
				if(downHillUnits > upHillUnits && downHillUnits != 0) {
					didStartDownhill = true;
					isSeaLevel = false;
				}
			} else {
				upHillUnits++;
				if (downHillUnits == upHillUnits && downHillUnits != 0) {
					isSeaLevel = true;
				}
				else {
					isSeaLevel = false;
				}
				
			}
			if(isSeaLevel && didStartDownhill) {
				result++;
				didStartDownhill = false;
			}
		}
		
		return result;
	}
}
