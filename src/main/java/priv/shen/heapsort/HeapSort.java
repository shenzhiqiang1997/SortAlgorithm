package priv.shen.heapsort;
/*  这里是实现的最小堆
    数组中的0号位置不存放数据
    方便访问子节点和父节点
*/
public class HeapSort {
    public void sort(int[] numbers,int n){
        /* 从第一个非叶节点开始自下而上 自右向左地调整每个子树的根节点维护
           使其满足堆的结构 */
        for (int i = n/2; i >= 1; i--) {
            adjust(numbers,i,n);
        }
        /* 堆已经构建好了 */

        /*
            每次将堆顶与堆最末尾的元素交换
            之后再以整棵树的根节点进行规模减一进行调整结构
            最后堆会以逆序的形式存放在原数组中
         */
        for (int i = n; i >= 1 ; i--) {
            /* 将末尾的元素与堆顶交换 */
            numbers[0] = numbers[1];
            numbers[1] = numbers[i];
            numbers[i] = numbers[0];

            /* 以树根为起点进行规模减一的结构调整 */
            adjust(numbers,1,i-1);
        }

    }

    private void adjust(int[] numbers, int root, int n) {
        /* 将当前子树的根节点存放到0位置上 */
        numbers[0] = numbers[root];
        /* 找到左儿子的位置 */
        int k = root * 2;
        /* 当左儿子不是叶节点时应当继续调整结构 */
        while (k < n) {
            /* 找到左右儿子中最小的节点 之后k指向儿子中较小的那个*/
            if (k + 1 < n && numbers[k + 1] < numbers[k]) k++;
            /* 因为是自下而上地调整
               如果根节点已经比儿子节点要小
               则说明结构已经调整好了 退出循环
             */
            if (numbers[0] <= numbers[k])
                break;
            /* 否则就将儿子中较小的节点交换上来 */
            numbers[root] = numbers[k];
            /* 继续向下调整 直到初始的根节点找到合适的位置 才完成结构调整 */
            root = k;
            k = root * 2;
        }

        /* 此时已经完成结构调整 只需要将初始的根节点放到已找到的合适的位置 */
        numbers[root] = numbers[0];
    }
}
class HeapSortTest{
    public static void main(String[] args) {
        /* 下标为0的位置不放置元素 这里用无穷大来代替*/
        int[] numbers = new int[]{Integer.MAX_VALUE,2,5,1,3,6,4,9,7};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(numbers,numbers.length-1);
        /* 由于堆排序后会以倒序的形式存放到数组中 所以倒序输出就是排序结果 */
        for (int i = numbers.length-1; i >=1 ; i--) {
            System.out.print(numbers[i]+((i == 1)?"":","));
        }
    }
}
