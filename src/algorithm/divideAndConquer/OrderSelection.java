package algorithm.divideAndConquer;

/**
 * 次序选择问题：选择出第k大的元素
 */
public class OrderSelection {
    public static void main(String[] args) {
        int []a = {3,5,2,-1,10,20,80,15,66,22};
        for (int i = 1; i <= 10; i++) {
            System.out.println(orderSelection(a,i,0,a.length-1));
        }

    }

    /**
     * 使用分治算法找出数组a中第k大的元素
     * @param a 待查找的数组
     * @param k 第k大的
     * @param left 数组左边界
     * @param right 数组右边界
     * @return 第k大的值
     */
    public static int orderSelection(int[]a,int k,int left,int right){
        //先对数组进行排序，选择一个元素x,把比x小的放左边，把比x大的放右边，中间的值的下标记为p，
        //如果p==k，则返回
        //如果p>k,则在左侧继续查找
        //如果p<k,则在右侧继续查找

       if(k>right-left+1||left<0||right<0){
            return 0;
        }
        if(left==right){
            return a[left];
        }
        int i = left;
        int j = right;
        //选择第一个元素作为比较
        int m = a[left];
        while (i<j){
            while (i<j&&a[j]>m)
                j--;
            a[i]=a[j];
            while (i<j&&a[i]<=m)
                i++;
            a[j]=a[i];
        }
        a[i]=m;
        if(i+1-left==k)
            return  a[i];
        //在右边搜索
        else if (i+1-left<k){
            i = orderSelection(a,k+left-i-1,i+1,right);
        }else{
            i = orderSelection(a,k,left,i-1);
        }
        return i;
    }
}
