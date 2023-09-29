package task1;

import java.util.Arrays;

public class MyArray {
	private int[] arr;

	public MyArray(int[] arr) {
		this.arr = arr;
	}

	// tast1.1
	public int[] mirror() {
		int[] result = new int[arr.length * 2];
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
			result[arr.length * 2 - 1 - i] = arr[i];
		}

		return result;
	}

	public int[] removeDuplicates() {
		int index = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					if (arr[i] == arr[j]) {
						arr[j] = 0;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count++;
			}
		}
		int[] result = new int[arr.length - count];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				result[index++] = arr[i];
			}
		}
		return result;
	}

	// task1.2
	public int[] getMissingValues() {
		int max = arr[arr.length - 1];
		int min = arr[0];
		int count = max - min;
		int[] temp = new int[count + 1];
		int index = 0;
		for (int i = 0; i < count + 1; i++) {
			temp[i] = min++;
		}
		int[] result = new int[temp.length - arr.length];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (temp[i] == arr[j]) {
					temp[i] = 0;
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				result[index++] = temp[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 2, 2, 3, 2, 3, 4, 4, 4, 4, 7, 2, 2, 2, 8, 9 };
		int[] arr3 = { 1, 2, 3, 5, 6, 8 };
		
		MyArray re1 = new MyArray(arr1);
		System.out.println(Arrays.toString(re1.mirror()));

		MyArray re2 = new MyArray(arr2);
		System.out.println(Arrays.toString(re2.removeDuplicates()));

		MyArray re3 = new MyArray(arr3);
		System.out.println(Arrays.toString(re3.getMissingValues()));
	}
}
