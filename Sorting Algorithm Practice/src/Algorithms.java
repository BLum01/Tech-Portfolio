/* Brandon Lum
 * 
 */
import java.util.Arrays;

public class Algorithms {
	public static void main(String[]args) {
		int arrSize = (int)(100*Math.random()+1);
		int[] arr = new int[arrSize];
		
		for (int i = 0; i<arr.length; i++) {
			arr[i] = (int)(100* Math.random()+1);
		}
		System.out.println("Unsorted Array:");
		System.out.println(Arrays.toString(arr));
		System.out.println("Sorted Array:");
		System.out.println(Arrays.toString(selectionSort(arr)));

	}
	
	public static int[] insertion(int[] array) {
		for (int i = 0; i < array.length-1; i++){
			int h = i;
			while (h>=0 && array[h+1] < array[h] ) {
				int temp = array[h+1];
				array[h+1] = array[h];
				array[h] = temp;
				h--;

				}
			}
		
		return array;
	}
	
	
	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] > arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		if(isSorted(arr)) {
			return arr;
		} else {
			bubbleSort(arr);
		}
		return arr;
	}
	
	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int max = arr[i];
			int maxIndex = i;
			//checks if rest of valeus are the max
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
					maxIndex = j;
				}
			}
			
			arr[maxIndex] = arr[arr.length-1-i];
			arr[arr.length-1-i] = max;
		}
		return arr;
		
	}
	
	//returns boolean if the array is sorted from least to greatest
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] >  arr[i+1]) {
				return false;
			}
		}
		
		return true;
	}
}