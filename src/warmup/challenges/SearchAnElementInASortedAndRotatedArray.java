package warmup.challenges;

public class SearchAnElementInASortedAndRotatedArray {

	public static void main(String[] args) {
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int index=  findPivotIndex(arr, 0, arr.length-1);

	}

	private static int findPivotIndex(int[] arr, int startIndex, int endIndex) {
		if(startIndex > endIndex) {
			System.out.println("returning -1 as "+startIndex+" >"+endIndex);
			return -1;
		}
		int mid= (startIndex + endIndex) / 2;
		if(mid+1 >= arr.length-1 || mid-1< 0 ) {
			System.out.println("returning -1 as mid+1 >arr.length-1 or mid -1< 0");
			return -1;
		}
		if(arr[mid]> arr[mid+1] && arr[mid]<arr[mid-1]) {
			System.out.println("returning the wanted index value!!!!! "+mid);
			return mid;
		}
		if(startIndex<endIndex) {
			int midMinusOne= mid-1;
			System.out.println("findPivotIndex with startIndex"+startIndex +" and end Index midMinusOne:"+ midMinusOne);
			return findPivotIndex(arr, startIndex,midMinusOne );
		}
		int midPlusOne= mid+1;
		System.out.println("findPivotIndex with startIndex midPlusOne"+midPlusOne +" and endIndex:"+ endIndex);
		return findPivotIndex(arr, mid+1, endIndex);
	}

}
