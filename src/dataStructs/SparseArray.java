package dataStructs;

public class SparseArray {
    public static void main(String[] args) {
        int cheddArr1[][] = new int[11][11];
        cheddArr1[1][2] = 1;
        cheddArr1[2][3] = 2;
        System.out.println("原始的二维数组");
        for (int [] as: cheddArr1) {
            for (int a:as){
                System.out.printf("%d\t",a);
            }
            System.out.println();
        }
        int sum = 0;
        for (int [] as: cheddArr1) {
            for (int a:as){
                if(a>0) sum++;
            }
        }
        System.out.printf("sum=%d\n", sum);
        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(cheddArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = cheddArr1[i][j];
                }
            }
        }

        for (int i = 0;i<sparseArr[0][2]+1;i++){
            for (int j = 0; j < 3; j++) {
                System.out.printf("%d\t" , sparseArr[i][j]);
            }
            System.out.println();
        }
    }
}
