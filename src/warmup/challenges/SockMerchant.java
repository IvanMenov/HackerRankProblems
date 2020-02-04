package warmup.challenges;

import java.io.*;
import java.util.*;

//https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	ArrayList<Integer>[] arrayList = new ArrayList[101];
        int result = 0;
	    
        for (int i = 0; i < ar.length; i++) {
			int arElement= ar[i];
			if(arrayList[arElement] == null) {
				arrayList[arElement] = new ArrayList<Integer>();
			}
			arrayList[arElement].add(arElement);
		}
       	for (int i = 0; i < arrayList.length; i++) {
       		if(arrayList[i] != null) {
       			result += arrayList[i].size()/2;
       		}
       		
		}
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

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
        System.out.println(result);
        scanner.close();
    }
}
