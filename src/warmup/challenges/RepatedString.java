package warmup.challenges;

import java.util.Scanner;

public class RepatedString {

	  private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args){
	        
	        String s = scanner.nextLine();

	        long n = scanner.nextLong();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        long result = repeatedString(s, n);

	        System.out.println(result);

	        scanner.close();
	    }

		private static long repeatedString(String text, long n) {
			StringBuilder newString= new StringBuilder();
			long result = 0;
			
			if(!text.contains("a")) {
				return 0;
			}
			if(text.length() == n) {
				result = iterateString(text);
			}
			else if(text.length() > n) {
				newString.append(text.substring(0, (int)n));
				result = iterateString(newString.toString());
			}
			
			else {
				result = iterateString(text);
				long remainder = n % text.length();
				long division = n / text.length();
				
				result = (division*result);
				if(remainder != 0) {
					text = text.substring(0, (int)remainder);
					result = result + iterateString(text);
				}
			}
			return result;
			
		}

		private static long iterateString(String newString) {
			long res = 0;
			for (char charater : newString.toCharArray()) {
				if(charater =='a') {
					res =res +1;
				}
			}
			return res;
		}
}
