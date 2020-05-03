package algorithm.divideAndConquer;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int []shares = {10,5,6,13,1,99,66};
        mergeSort(shares,0,shares.length-1);
        System.out.println(Arrays.toString(shares));
    }

    /**
     * 归并排序算法
     * @param a
     * @param left
     * @param right
     */
    public static void mergeSort(int []a,int left,int right){
        if (left>=right) return;
        int mid = (left + right)/2;
        mergeSort(a,left,mid);
        mergeSort(a,mid+1,right);
        merge(a,left,mid,right);
    }

    /**
     *  归并排序算法的合并
     * @param a 待排序数组
     * @param left 左下标
     * @param mid 分割下标
     * @param right 右下标
     */
    private static void merge(int[] a, int left, int mid, int right) {
        int []t = new int[right-left+1];
        int i=left;
        int k=0;
        int j=mid+1;
        while (i<=mid&&j<=right){
            if (a[i]>a[j]){
                t[k++]=a[j++];
            }else t[k++]=a[i++];

        }
        while (i<=mid)
            t[k++] = a[i++];
        while (j<=right)
            t[k++] = a[j++];
        for (i = 0,j=left; i < t.length; i++,j++) {
            a[j]=t[i];
        }

    }
}
