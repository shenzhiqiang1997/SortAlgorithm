package priv.shen.selectsort;

import java.util.Arrays;

public class SelectSort {
    public void sort(int[] numbers){
        for (int i = 0; i < numbers.length; i++) {
            int min = i;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j]<numbers[min]){
                    min = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
        }
    }
}

class SelectSortTest{
    public static void main(String[] args) {
        int[] numbers = new int[]{2,5,1,3,6,4,9,7};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
