package arthurimmich.pancakesort;
//Contribuited by Arthur Immich
import java.util.Arrays;

public class PancakeSort {
    
    static int[] pancakeSort(int[] array) {
        for(int arraySize = array.length-1; arraySize >= 0; arraySize--){
            int pancakeIndex = pancakeIndex(array, arraySize);
            if(pancakeIndex != (arraySize) && array[pancakeIndex] != array[arraySize]){ //no need for a pancakes flip if 
                if(pancakeIndex != 0 ){          //no need for a flip if                //the pancake is in its right position 
                    flip(array, pancakeIndex);   //the pancake is already on top        //or if there is an equal in its place
                }
                flip(array, arraySize);
            }
        }
        return array;
    }

    //perfoms the flip
    public static void flip(int[] array, int pancakeIndex) {
        int i = 0, temp = 0;
            while (i < pancakeIndex) {
                temp = array[pancakeIndex];
                array[pancakeIndex] = array[i];
                array[i] = temp;
                i++;pancakeIndex--;
            }
            System.out.printf("After flip array\n");
            Arrays.stream(array).forEach(val -> System.out.println(val));
    }
    
    //find the highest index of the array
    public static int pancakeIndex(int[] array, int unsortedEnd) {
        int pancakeIndex = 0;
        for (int i = 0; i < unsortedEnd; i++) {
            if (array[i] > array[pancakeIndex]) {
                pancakeIndex = i;
            }
        }
        return pancakeIndex;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,4,6,5,3};
        System.out.printf("Array before sorting\n");
        Arrays.stream(array).forEach(val -> System.out.println(val));
        int[] result = pancakeSort(array);
    }
}
