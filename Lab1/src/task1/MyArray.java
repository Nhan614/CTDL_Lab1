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
	// getMissingValues
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
	//fillMissingValues
	public int[] fillMissingValues(int k) {
		int[] result = arr.clone();
		int y = 0;
		for (int i = 0; i < arr.length; i++) {
			int index1 = i - ((k + 1) / 2);
			int index2 = i + ((k + 1) / 2);
			if (arr[0] == -1 && i == 0) {
				for (int a = 1; a <= k; a++) {
					y += arr[a];
				}
				result[0] = y / k;
			}
			if (arr[i] == -1 && i == arr.length - 1) {
				for (int b = arr.length - 1; b >= arr.length - 1 - k; b--) {
					y += arr[b];
				}
				result[arr.length - 1] = y / k;
			}
			if (arr[i] == -1 && arr[0] != -1 && arr[arr.length - 1] != -1) {
				if (k % 2 == 0) {
					for (int j = index1; j <= index2; j++) {
						if (arr[j] != -1) {
							y += arr[j];
						}
					}
				} else {
					if (arr[index1] < arr[index2]) {
						for (int z = index1; z < index2; z++) {
							if (arr[z] != -1) {
								y += arr[z];
							}
						}
					}
					if (arr[index1] > arr[index2]) {
						for (int z = index2; z > index1; z--) {
							if (arr[z] != -1) {
								y += arr[z];
							}
						}
					}
				}
				result[i] = y / k;
			}
		}
		return result;
	}


	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 1, 2, 2, 2, 3, 2, 3, 4, 4, 4, 4, 7, 2, 2, 2, 8, 9 };
		int[] arr3 = { 1, 2, 3, 5, 6, 8 };
		int[] arr4 = { 10, 11, 12, -1, 14, 10, 17, 19, 20 };

		MyArray re1 = new MyArray(arr1);
		System.out.println(Arrays.toString(re1.mirror()));

		MyArray re2 = new MyArray(arr2);
		System.out.println(Arrays.toString(re2.removeDuplicates()));

		MyArray re3 = new MyArray(arr3);
		System.out.println(Arrays.toString(re3.getMissingValues()));
		
		MyArray re4 = new MyArray(arr4);
		System.out.println(Arrays.toString(re4.fillMissingValues(3)));
	}
}
