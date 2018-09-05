package priv.shen.quicksort;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] numbers){
        /* 对数组进行快速排序 */
        quickSort(numbers,0,numbers.length-1);
    }

    private void quickSort(int[] numbers,int low,int high){
        /* 如果low<high 说明数组可以继续划分数组进行递归快排 */
        if (low<high){
            /*
            按照划分元
            将比划分元小的元素放到左侧 比划分元大的元素放到右侧 并返回划分元的位置
            即进行切分
             */
            int idx = partition(numbers,low,high);
            /* 递归的对左侧进行快速排序 */
            quickSort(numbers,low,idx-1);
            /* 递归地对右侧进行快速排序 */
            quickSort(numbers,idx+1,high);
        }
    }

    private int partition(int[] numbers, int low, int high) {
        /* 默认采用low所在的元素作为划分元 此时low的位置空了出来*/
        int partitionElement = numbers[low];
        /* 当low<high说明元素位置还可以继续调整 */
        while (low<high){
            /* 找到右侧比划分元小的元素 */
            while (low<high && numbers[high]>=partitionElement)
                high--;
            /* 将比划分元小的元素交换到左侧的空位low 此时位置high空了出来 */
            if (low<high)
                numbers[low++] = numbers[high];

            /* 找到左侧比划分元大的元素 */
            while (low<high && numbers[low]<=partitionElement)
                low++;
            /* 将比划分元大的元素交换到右侧的空位high 此时位置low 空了出来 */
            if (low<high)
                numbers[high--] = numbers[low];
        }

        /* 最后low == high low所在的位置就是划分元的位置 */
        numbers[low] = partitionElement;
        return low;
    }
}
class QuickSortTest{
    public static void main(String[] args) {
        int[] numbers = new int[]{2,5,1,3,6,4,9,7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
