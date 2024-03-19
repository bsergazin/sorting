/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        int[] array = new int[] {1, 6, 2, 0, 10, 2};
        BubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

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
    


}