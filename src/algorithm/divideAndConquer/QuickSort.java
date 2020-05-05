package algorithm.divideAndConquer;

import java.util.Arrays;

/**
 * 快速排序
 * 找到一个位置的元素，比他小的都放左边，比他大的都放右边
 * 1. 在待排序的N个记录中任取一个元素(通常取第一个记录)作为基准，称为基准记录；
 * 2. 定义两个索引 left 和 right 分别表示“首索引” 和 “尾索引”，key 表示“基准值”；
 * 3. 首先，尾索引向前扫描，直到找到比基准值小的记录(left != righ)，并替换首索引对应的值；
 * 4. 然后，首索引向后扫描，直到找到比基准值大于的记录(left != righ)，并替换尾索引对应的值；
 * 5. 若在扫描过程中首索引等于尾索引(left = right),则一趟排序结束；将基准值(key)替换首索引所对应的值；
 * 6. 再进行下一趟排序时，待排序列被分成两个区:[0,left-1],[righ+1,end]
 * 7. 对每一个分区重复步骤2~6，直到所有分区中的记录都有序，排序成功。
 */
public class QuickSort {
    public static void main(String[] args) {
        int []a = {2,99,35,4,-10,66,2,5};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    /**
     *
     * @param a 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    public static void quickSort(int[]a,int left,int right){
        if (left>=right) return;
        int t = a[left];
        int i=left;
        int j=right;
        while (i<j){
            while (i<j&&a[j]>t)
                j--;
            a[i]=a[j];
            while (i<j&&a[i]<=t)
                i++;
            a[j]=a[i];
        }
        a[i]=t;
        quickSort(a,left,i-1);
        quickSort(a,i+1,right);
    }
}
