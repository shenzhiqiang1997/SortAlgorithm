package priv.shen.mergesort;

import java.util.Arrays;

public class MergeSort {
    public void sort(int[] numbers){
        /* 辅助数组 用于排序与合并操作 等合并后再将合并结果写回原数组*/
        int[] temp = new int[numbers.length];
        System.arraycopy(numbers,0,temp,0,numbers.length);

        /* 对数组整体进行归并排序 */
        sort(numbers,temp,0,numbers.length-1);
    }

    private void sort(int[] numbers, int[] temp, int start, int end) {
        /* 如果start<end 说明可以继续二分 否则已经划分到单个元素 无法再划分*/
        if (start<end){
            int mid = (start+end)/2;
            /* 对前半部分进行归并排序 */
            sort(numbers,temp,start,mid);
            /* 对后半部分进行归并排序*/
            sort(numbers,temp,mid+1,end);
            /* 此时前半部分和后半部分已经分别有序排列
            只需要将前半部分和后半部分合并后更新到原数组 */
            merge(numbers,temp,start,mid,end);
        }
    }

    private void merge(int[] numbers, int[] temp, int start, int mid, int end) {
        int i = start,j = mid+1,index = start;
        /* 从前半部分和右半部分的第一个元素开始比较
        每次把两个部分中较小的元素按顺序存放到辅助数组中
        之后再移动指针继续比较 直到其中一个指针超过所在部分的尾部*/
        while (i <= mid && j <= end){
            /* 这里要小于等于 原因在于
            对于相等元素一定要让前半部分的那个元素放在前面从而保证稳定性*/
            if (numbers[i] <= numbers[j])
                temp[index++] = numbers[i++];
            else
                temp[index++] = numbers[j++];
        }

        /*
           当一个部分的指针超过尾部
           说明另一部分的剩余部分都要比该部分的元素要大
           将这部分直接衔接到辅助数组的后续位置
        */

        while (i <= mid)
            temp[index++] = numbers[i++];
        while (j <= end)
            temp[index++] = numbers[j++];

        /* 将合并后的部分更新到原数组 */
        System.arraycopy(temp,start,numbers,start,end-start+1);

    }
}
class MergeTest{
    public static void main(String[] args) {
        int[] numbers = new int[]{2,5,1,3,6,4,9,7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
