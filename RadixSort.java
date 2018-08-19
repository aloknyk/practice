package com.ak.sorting;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {

		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
		int max = Arrays.stream(arr).max().getAsInt();
		for (int i = 1; max / i > 0; i *= 10) {
			radixSort(arr, i);
		}
		System.out.println();
		Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
	}

	private static void radixSort(int[] arr, int i) {
		int output[] = new int[arr.length];
		int bucket[] = new int[10];

		for (int j = 0; j < arr.length; j++) {
			bucket[(arr[j] / i) % 10]++;
		}

		for (int j = 1; j < bucket.length; j++) {
			bucket[j] += bucket[j - 1];
		}
		
		for (int j = arr.length - 1; j >= 0; j--) {
			output[bucket[(arr[j] / i) % 10] - 1] = arr[j];
			bucket[(arr[j] / i) % 10]--;
		}

		System.arraycopy(output, 0, arr, 0, output.length);

	}

}
