/*Реализовать алгоритм сортировки слиянием. */

import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) {
        int[] numbers = {2,7,3,6,1,9,78,56,43,23,99,2,4,15};
        int[] result = sortArray(numbers);
        System.out.println(Arrays.toString(result));
    }
 
    public static int[] sortArray(int[] numbers) {
        int[] tempArray = new int[numbers.length];
        int[] result = mergeArray(numbers, tempArray, 0, numbers.length);
        return result;
    }
 
    public static int[] mergeArray(int[] numbers, int[] tempArray,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return numbers;
        }
        
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeArray(numbers, tempArray, startIndex, middle);
        int[] sorted2 = mergeArray(numbers, tempArray, middle, endIndex);
        
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == numbers ? tempArray : numbers;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

}

