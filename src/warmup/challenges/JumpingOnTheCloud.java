package warmup.challenges;

import java.util.Scanner;

public class JumpingOnTheCloud {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);
		
	}

	private static int jumpingOnClouds(int[] clouds) {
		int result = 0;
		int index=0;
		while (index < clouds.length) {
			if (index < clouds.length - 2 && clouds[index + 2] == 0) {
				index += 2;
				result++;
			} else {
				index += 1;
				result++;
			}
			

		}
		return result;
	}
}
