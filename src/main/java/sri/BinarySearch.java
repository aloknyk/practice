package sri;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int [] arr = {6,7,12,14,24,32,45};
		int index = binarySearch(arr,0,arr.length,99);
		if(-1 != index)
			System.out.println("Found at position: "+ (index+1));
		else
			System.out.println("Not found");
	}

	private static int binarySearch(int[] A,int left,int right, int k) {
		if(left < right){
			int guess = (left+right)/2;
			
			if(k == A[guess])
				return guess;
			if(A[guess] > k)
				return binarySearch(A,left,guess-1, k);
			else
				return binarySearch(A,guess+1,right, k);
		}
		return -1;
	}
}
