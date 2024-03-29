/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int arrLength = 100;
        int[] array = new int[arrLength];

        for(int i = 0; i < arrLength; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        
        int[] bubbleSortArray = array.clone();       
        int[] selectionSortArray = array.clone();
        int[] insertionSortArray = array.clone();
        int[] mergeSortArray = array.clone();
        int[] quickSortArray = array.clone();
              
        long bubbleSortStartTime = System.nanoTime();
        BubbleSort(bubbleSortArray);
        long bubbleSortTime = System.nanoTime() - bubbleSortStartTime;

        long selectionSortStartTime = System.nanoTime();
        SelectionSort(selectionSortArray);
        long selectionSortTime = System.nanoTime() - selectionSortStartTime;

        long insertionSortStartTime = System.nanoTime();
        InsertionSort(insertionSortArray);
        long insertionSortTime = System.nanoTime() - insertionSortStartTime;

        long mergeSortStartTime = System.nanoTime();
        MergeSort(mergeSortArray, 0, mergeSortArray.length - 1);
        long mergeSortTime = System.nanoTime() - mergeSortStartTime;

        long quickSortStartTime = System.nanoTime();
        QuickSort(quickSortArray);;
        long quickSortTime = System.nanoTime() - quickSortStartTime;
        
                      
        System.out.println("Bubble Sort time elapsed = " + bubbleSortTime);
        System.out.println("Selection Sort time elapsed = " + selectionSortTime);
        System.out.println("Insertion Sort time elapsed = " + insertionSortTime);
        System.out.println("Merge Sort time elapsed = " + mergeSortTime);
        System.out.println("Quick Sort time elapsed = " + quickSortTime);

    }

    public static void BubbleSort(int[] inputArray) {
        for(int i = 0; i < inputArray.length - 1; i++) {
            for(int j = 0; j < inputArray.length - i - 1; j++) {
                if(inputArray[j] > inputArray[j+1]){
                    int tmp = inputArray[j];
                    inputArray[j] = inputArray[j+1];
                    inputArray[j+1] = tmp;
                }
            }
        }
    }

    public static void SelectionSort(int[] inputArray) {
        int minIndex, tmp;
        for(int i = 0; i < inputArray.length - 1; i++) {
            minIndex = i;            
            for(int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[j] < inputArray[minIndex]) {
                    minIndex = j;
                }
            }            
            tmp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = tmp;
        }
    }

    public static void InsertionSort(int[] inputArray) {
        for(int i = 1; i < inputArray.length; i++) {
            int tmp = inputArray[i];
            int j;
            for(j = i - 1; j > -1 && inputArray[j] > tmp; j--) {
                inputArray[j+1] = inputArray[j];
            }
            inputArray[j+1] = tmp;
        }
    }

    public static void MergeSort(int[] inputArray, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            MergeSort(inputArray, left, middle);
            MergeSort(inputArray, middle + 1, right);
            MergeArrays(inputArray, left, middle, right);
        }
    }

    public static void MergeArrays(int[] inputArray, int left, int middle, int right) {
        int nLeft = middle - left + 1;
        int nRight = right - middle;

        int[] arrayLeft = new int[nLeft];
        int[] arrayRight = new int[nRight];

        for(int i = 0; i < nLeft; i++) {
            arrayLeft[i] = inputArray[left + i];
        } 
        for(int i = 0; i < nRight; i++) {
            arrayRight[i] = inputArray[middle + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while(i < nLeft && j < nRight) {
            if(arrayLeft[i] <= arrayRight[j]) {
                inputArray[k] = arrayLeft[i];
                i++;
            } else {
                inputArray[k] = arrayRight[j];
                j++;
            }
            k++;
        }

        while(i < nLeft) {
            inputArray[k] = arrayLeft[i];
            i++;
            k++;
        }

        while(j < nRight) {
            inputArray[k] = arrayRight[j];
            j++;
            k++;
        }
    }
 
    public static void QuickSort(int[] inputArray) {
        RecursiveQuickSort(inputArray, 0, inputArray.length - 1);
    }

    /**
     * Will recursively call itself to perform quickSort
     * @param inputArray
     * @param low
     * @param high
     */
    public static void RecursiveQuickSort(int[] inputArray, int low, int high) {
        if(low < high) {
            int pivotIdx = Partition(inputArray, low, high);
            RecursiveQuickSort(inputArray, low, pivotIdx - 1);       
            RecursiveQuickSort(inputArray, pivotIdx + 1, high);
        }         
    }

    public static int Partition(int[] inputArray, int low, int high) {
        // choose pivot
        int pivot = inputArray[high];
        int i = low - 1;
        int j = low;

        while(j <= high) {
            if(inputArray[j] < pivot) {
                i++;
                Swap(inputArray, i, j);
            } 
            j++;    
        }
        Swap(inputArray, i+1, high);
        return i + 1;
    }

    public static void Swap(int[] inputArray, int i, int j) {
        int tmp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = tmp;
    }
}