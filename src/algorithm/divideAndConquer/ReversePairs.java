package algorithm.divideAndConquer;

/**
 * 逆序对：对于数组a[n],当0<=i<j<n,有a[i] > a[j]
 */
public class ReversePairs {
    public static void main(String[] args) {
        int []shares = {7, 5, 1, 6, 4};
        System.out.println(bruteForce(shares));
        System.out.println(reversePairs(shares,0,shares.length-1));
    }

    /**
     * 使用归并排序求解数组中的逆序对数
     * @param a 待求解数组
     * @param left 数组左边界
     * @param right 数组右边界
     * @return 逆序对数
     */
    public static int reversePairs(int[]a,int left,int right){
        if (left==right){
            return 0;
        }
        int mid = (left+right)/2;
        int l = reversePairs(a,left,mid);
        int r = reversePairs(a,mid+1,right);
        int s = mergeSortSum(a,left,mid,right);
        return l+r+s;

    }

    /**
     * 归并排序计算逆序对个数
     * @param a
     * @param left
     * @param right
     * @return 逆序对个数
     */
    public static int mergeSortSum(int[] a, int left,int mid, int right) {
        int s=0;
        int i=mid;
        int j=right;
        int k=right-left;
        int []t = new int[right-left+1];
        while (i>=left&&j>mid){
            if(a[i]>a[j]){
                s+=j-mid;
                t[k--]=a[i--];
            }else t[k--]=a[j--];
        }
        while (i>=left){
            t[k--]=a[i--];
        }
        while (j>mid){
            t[k--]=a[j--];
        }
        for (i=left,j=0;i<=right;i++,j++)
            a[i]=t[j];
        return s;
    }

    /**
     *
     * @param array 待测试数组
     * @return
     */
    public static int bruteForce(int []array){
        int sum=0;
        for (int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    sum++;
                }
            }
        }

        return sum;
    }
}
