package algorithm.divideAndConquer;

public class Hanoitower {
    public static void main(String[] args) {
        hanoitower(5,'A','B','C');
    }
    //汉诺塔的移动方案
    public static void hanoitower(int num,char a,char b,char c){
        if (1==num){
            System.out.println("第 1 个盘从 " + a+" -> " + c);
        }else {
            hanoitower(num-1,a,c,b);
            System.out.println("第 " + num+" 个盘从 " + a+" -> " + c);
            hanoitower(num-1,b,a,c);
        }
    }
}
