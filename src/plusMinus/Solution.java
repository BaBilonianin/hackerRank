package plusMinus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float[] result = countResult(countAllCounts(arr),arr.length);
        printResult(result);
    }

    static int[] countAllCounts(int[] arr) {
        int positive = 0, negative = 0, zero = 0, size=0;
        for (int i : arr) {
            if (i > 0) positive++;
            else if (i < 0) negative++;
            else zero++;
        }
        return new int[]{positive, negative, zero, size};
    }

    private static float[] countResult(int[] i, int size) {
        float[] result = new float[3];
        result[0] =(float) i[0] / size;
        result[1] =(float)  i[1] / size;
        result[2] =(float)  i[2] / size;
        return result;
    }

    static void printResult(float[] result) {
        for (float i : result) {
            System.out.println(i);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}


