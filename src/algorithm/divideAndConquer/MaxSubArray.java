package algorithm.divideAndConquer;

/**
 * 最大子串和
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] shares = {-2,1,-3,4,-1,2,1,-5,4};
        int [] shares2={-20,11,-4,13,-5,-2};
        System.out.println(bruteForce(shares));
        System.out.println(bruteForceImprove(shares));
        System.out.println(divideConquer(shares2,0,shares2.length-1));
    }
    public static Result divideConquer(int [] array,int l,int r){
        if(l==r)
            return new Result(l,r,array[l]);
        else {
            int mid = (l+r)/2;
            Result leftResult = divideConquer(array,l,mid);
            Result rightResult = divideConquer(array,mid+1,r);
            int sl=array[mid];
            int sli=mid;

            int slt=array[mid];


            for (int i=mid-1;i>=l;i--){
                slt+=array[i];
                if(slt>sl){
                    sl=slt;
                    sli=i;
                }
            }
            int sr = array[mid+1];
            int srj = mid+1;
            int srt = array[mid+1];
            for(int j=mid+2;j<=r;j++){
                srt+=array[j];
                if(srt>sr){
                    sr = srt;
                    srj=j;
                }
            }
            Result midResult = new Result(sli,srj,sl+sr);
            if(leftResult.sum>rightResult.sum && leftResult.sum>midResult.sum){
                return leftResult;
            }else if(rightResult.sum>midResult.sum){
                return rightResult;
            }else {
                return midResult;
            }
        }



    }
    //改进的暴力法
    public static Result bruteForceImprove(int [] array){
        int []sums=new int[array.length] ;
        int l=0,r=0,sum=array[0];
        for (int i=0;i<array.length;i++){
            sums[i]=array[i];
            if(sums[i]>sum){
                sum = sums[i];
                l=i;
                r=i;
            }
            for (int j=i+1;j<array.length;j++){
                sums[j] = sums[j-1]+array[j];
                if(sums[j]>sum){
                    sum = sums[j];
                    l=i;
                    r=j;
                }
            }
        }
        return new Result(l,r,sum);
    }
    static class Result{
        int left;
        int right;
        int sum;

        public Result(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "left=" + left +
                    ", right=" + right +
                    ", sum=" + sum +
                    '}';
        }
    }

    public static int sum(int[]array,int l,int r){
        int sum=0;
        for (int i=l;i<=r;i++){
            sum+=array[i];
        }
        return sum;
    }

    //暴力法
    public static Result bruteForce(int [] array){

        int l=0,r=0,sum=Integer.MIN_VALUE;
        for (int i=0;i<array.length;i++){
            for (int j=i;j<array.length;j++){
                int s = sum(array,i,j);
                if(s>sum){
                    sum = s;
                    l=i;
                    r=j;
                }
            }
        }


        return new Result(l,r,sum);
    }

}
