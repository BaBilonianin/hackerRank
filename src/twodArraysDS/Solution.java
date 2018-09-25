package twodArraysDS;

/**
 * Created on 24.09.2018.
 */
public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] a) {
        int result = 0, temp = 0;
        for (int i = 0; i < a.length - 2; i++)
            for (int j = 0; j < a[0].length - 2; j++) {
                temp = a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
                if (result < temp) result = temp;
            }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 1, 1, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
                if (j == a[0].length - 1)
                    System.out.print("\n");
            }
        }
        System.out.print(hourglassSum(a)+"\n");
        System.out.print(a[4][3]);
    }

}
