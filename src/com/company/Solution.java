package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int result = 0;
//        result+=countLeftUp(n,k,r_q,c_q,obstacles);
//        result+=countUp();
//        result+=countRightUp();
//        result+=countRight();
//        result+=countRightDown();
//        result+=countDown();
//        result+=countLeftDown();
//        result+=countLeft();
        return result;
    }

    private static int countLeftUp(int n, int k, int r_q, int c_q, int[][] obstacles){
        int result=0;
        if(checkIfPossibleSquaresExist(r_q,c_q,n)){
//            for(int i=r_q-1; i<;i++) {
//                if(checkIfObstacleInThisPosition(r_q-1,c_q-1,obstacles)) break;
//                result++;
//            }
        }
        return result;
    }

    private static boolean checkIfObstacleInThisPosition(int r, int c,int[][] obstacles) {
        for(int i=0;i<obstacles.length;i++){
            if(obstacles[i][0]==r && obstacles[i][1]==c){
                return false;
            }
        }
        return true;
    }

    private static boolean checkIfPossibleSquaresExist(int r_q, int c_q, int n) {
        return (r_q-1)<n-1&&(c_q-1)>0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nk = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nk[0]);
//
//        int k = Integer.parseInt(nk[1]);
//
//        String[] r_qC_q = scanner.nextLine().split(" ");
//
//        int r_q = Integer.parseInt(r_qC_q[0]);
//
//        int c_q = Integer.parseInt(r_qC_q[1]);
//
//        int[][] obstacles = new int[k][2];
//
//        for (int i = 0; i < k; i++) {
//            String[] obstaclesRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 2; j++) {
//                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
//                obstacles[i][j] = obstaclesItem;
//            }
//        }
//
//        int result = queensAttack(n, k, r_q, c_q, obstacles);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();


        int n = 7;

        int k = 3;

        int r_q = 1;

        int c_q = 7;

        int[][] obstacles = new int[k][2];

        obstacles[1][0] = 2;
        obstacles[1][1] = 2;


        obstacles[2][0] = 2;
        obstacles[2][1] = 2;


        obstacles[0][0] = 2;
        obstacles[0][1] = 2;

        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
    }
}
