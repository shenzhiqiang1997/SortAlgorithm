package priv.shen.selectsort;

import java.util.Arrays;

public class SelectSort {
    public void sort(int[] numbers){
        /* 从左到右对于每个位置 */
        for (int i = 0; i < numbers.length; i++) {
            int min = i;
            /* 从其后剩余的部分选择一个最小元素与当前位置交换 */
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
