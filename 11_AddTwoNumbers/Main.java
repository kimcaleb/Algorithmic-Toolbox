





int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };
// First loop initializes the gap value that we will be using and reduces it after each iteration until gap is 0. We need a gap of 1 for the final iteration, which is basically our insertion sort implementation.  
for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
	for (int i = gap; i < intArray.length; i++) {
		int newElement = intArray[i];
		int j = i;
		while (j >= gap && intArray[j - gap] > newElement) {
			intArray[j] = intArray[j - gap];
			j -= gap;
		}
		intArray[j] = newElement;
	}
}