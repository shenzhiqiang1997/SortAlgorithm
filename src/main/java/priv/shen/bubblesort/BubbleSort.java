package priv.shen.bubblesort;

import java.util.Arrays;

public class BubbleSort {
    public void sort(int[] numbers){
        // i代表比较的轮数 n个数 一共要比较n-1轮
        for (int i = 1; i <=numbers.length -1; i++) {
            // j代表要比较的相邻数中第一个数的下标
            // 每一轮的最后一次比较只需要比较到已有序部分的前面两个数即可
            for (int j = 0; j <= numbers.length-i-1; j++) {
                if (numbers[j] > numbers[j+1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }

}
class BubbleSortTest{
    public static void main(String[] args) {
        int[] numbers = new int[]{2,5,1,3,6,4,9,7};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
