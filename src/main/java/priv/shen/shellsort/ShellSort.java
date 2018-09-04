package priv.shen.shellsort;

import java.util.Arrays;

public class ShellSort {
    public void sort(int[] numbers){
        /* 初始以数组长度/2为步长进行分组 之后不断将步长/2 直到步长为1进行最后一次分组*/
        for (int d = numbers.length/2; d >= 1; d=d/2) {
            /* 每次分组后遍历每组元素 */
            for (int i = 0; i < d; i++) {
                /* 对每组进行插入排序 */
                for (int j = i; j < numbers.length; j=j+d) {
                    for (int k = j; k > 0; k=k-d) {
                        if (numbers[k-1]>numbers[k]){
                            int temp = numbers[k-1];
                            numbers[k-1] = numbers[k];
                            numbers[k] = temp;
                        }
                    }
                }
            }
        }
    }
}
class ShellSortTest{
    public static void main(String[] args) {
        int[] numbers = new int[]{2,5,1,3,6,4,9,7};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
