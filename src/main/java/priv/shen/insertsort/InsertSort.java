package priv.shen.insertsort;

import java.util.Arrays;

public class InsertSort{
    public void sort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (numbers[j-1]>numbers[j]){
                    int temp = numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
class InsertSortTest{
    public static void main(String[] args) {
        int[] numbers = new int[]{2,5,1,3,6,4,9,7};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
