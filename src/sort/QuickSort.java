package sort;

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[20];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(30);
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		quickSort(arr, arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
	}
	
	public static void quickSort(int[] arr, int n) {
		quickSort(arr, 0, n-1);
	}
	
	public static void quickSort(int[] arr, int left, int right) {
		if(left >= right) 
			return;
		int pivot = quickSortCore(arr, left, right);	
		quickSort(arr, left, pivot - 1);
		quickSort(arr, pivot + 1, right);
		
	}
	
	/**
	 * 取最右作为核心，取两个指针，均在原数组上移动，将小于核心的交换到左侧
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	public static int quickSortCore(int[] arr, int left, int right) {
		int pivot = arr[right];
		int i = left;
		int j = left;
		for(; j < right; j++) {
			if(arr[j] < pivot) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
			}
		}
		//移动完成之后，最后i一定是停在>=pivot的位置，i左边都是小于pivot的，i右边都是大于等于pivot的。j一定是停在pivot的位置，它们需要再交换一次
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return i;
	}
}
