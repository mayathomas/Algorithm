package search;

import java.util.Random;

import sort.QuickSort;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(30);
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		QuickSort.quickSort(arr, arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		int i = binarySearch(arr, 11);
		System.out.println(i);
		
	}
	
	public static int binarySearch(int[] arr, int target) {
		
		return binarySearchCore(arr, 0, arr.length-1, target);
	}
	
	public static int binarySearchCore(int[] arr, int low, int high, int target) {
		
		if(low > high) 
			return -1;
		int mid = (low + high) / 2;
		System.out.println("=="+low+"=="+mid+"=="+high);
		if(arr[mid] == target) {
			return mid; 
		} else if(arr[mid] < target) {
			return binarySearchCore(arr, mid+1, high, target);
		} else {
			return binarySearchCore(arr, low, mid-1, target);
		}
	}
}
