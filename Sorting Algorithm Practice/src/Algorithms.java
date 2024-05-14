/* Brandon Lum
 * 
 */
import java.util.Arrays;

public class Algorithms {
	public static void main(String[]args) {

		/* lines 13 to 22 test the sorting implementation chosen by creating a array with a random size, filling it with random numbers, and printing the unsorted and sorted array
  		 * shows how I know how to create arrays and use Math.random()
		 */
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

	//insertion sorting method
	public static int[] insertion(int[] array) {
		for (int i = 0; i < array.length-1; i++){
			int h = i;
			/* I used a while loop here because I did not need to create another variable
   			 * This shows my ability to implement different loops
   			 */
			while (h>=0 && array[h+1] < array[h] ) {
				int temp = array[h+1];
				array[h+1] = array[h];
				array[h] = temp;
				h--;

				}
			}
		
		return array;
	}
	
	/* bubble sort sorting method
 	 * shows my ability to write recursive code
	 */
	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] > arr[i+1]) {
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		/* I used a private method because this code would be called multiple times, meaning that it
  		 * would use a lot of memory if it was written in this method. It also makes the code easier to read.
		 */
		if(isSorted(arr)) {
			return arr;
		} else {
			bubbleSort(arr);
		}
		return arr;
	}

	/* selection sort sorting method
	 */
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
	private static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] >  arr[i+1]) {
				return false;
			}
		}
		
		return true;
	}
}
