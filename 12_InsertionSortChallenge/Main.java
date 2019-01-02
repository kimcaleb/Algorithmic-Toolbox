
public class Main {

    public static void main(String[] args) {
        int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length;
             firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];

            int i;

            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }

            intArray[i] = newElement;
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
	
	//We pass in the array we want to sort and the number of items we want to sort until we have 1 item remaining. Each call to the inerstionSort method grows the sorted parition by 1. The recursive nature is replacing the outer for loop in the iterative solution. Once numItems is 1, we return to the insertionSort method with the numItems equal to 2. From there we do our regular for loop to iterate through the sorted partition from right to left to look for the insertion point for the 2nd item. When that finished, we return to the insertionSort method with the numItems equal to 3. And we again compare the value at the third position this time from right to left of the sorted parition to look for the insertion point. 
	public static void insertionSort(int[] input, int numItems) {
		if (numItems < 2)
			return;
		insertionSort(input,numItems-1);	
		int newElement = input[numItems-1];
		int i;
		for (i = numItems-1; i > 0 && input[i - 1] > newElement; i--) {
			input[i] = input[i - 1];
		}
		input[i] = newElement;
	}
}
