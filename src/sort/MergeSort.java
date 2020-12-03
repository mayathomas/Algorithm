package sort;

import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(30);
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		mergeSort(arr, arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
	
	public static void mergeSort(int[] arr, int n) {
		mergeSort(arr, 0, n-1);
	}
	
	public static void mergeSort(int[] arr, int left, int right) {
		
		if(left >= right) return;
		
		int mid = (left + right) / 2;
		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);
		mergeSortCore(arr, left, mid, right);
	}
	
	/**
	 * 合并数组元素，取两个指针，分别在两个数组上移动
	 * @param arr
	 * @param left
	 * @param mid
	 * @param right
	 */
	public static void mergeSortCore(int[] arr, int left, int mid, int right) {
		int[] newArr = new int[right-left+1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while(i <= mid && j <= right) {
			if(arr[i] <= arr[j]) {
				newArr[k++] = arr[i++]; 
			} else {
				newArr[k++] = arr[j++];
			}
		}
		int start = i,end = mid;
		if(j <= right) {
			start = j;
			end = right;
		}
		while(start <= end) {
			newArr[k++] = arr[start++];
		}
		for(int m = 0; m <= right - left; m++) {
			arr[left+m] = newArr[m];
		}
	}
}
