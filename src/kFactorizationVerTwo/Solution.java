package kFactorizationVerTwo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created on 18.09.2018.
 */
public class Solution {
    // Complete the kFactorization function below.
    public static void main(String[] args) {
        Date d = new Date(System.currentTimeMillis());
        System.out.print(d + "\n");
//        int n = 924000000;
//        int[] a = {2, 3, 5, 7, 11, 13, 17, 19};
//        int n = 132;
//        int[] a = {2, 3, 4, 11};
        int n = 175840877;
        int[] a = {4, 5, 6, 7, 8, 10, 12, 17, 18, 19};
        int[] result = kFactorization(n, a);
        for (int i : result)
            System.out.print(i + " ");
        System.out.print("\n");
        System.out.print(d.getTime() - System.currentTimeMillis());
    }

    private static int[] kFactorization(int n, int[] a) {
        mergeSort(a, 0, a.length - 1, false);
        kFactorizationFunction(n, a);
        return transform(resultArray);
    }

    private static int[] resultArray = new int[30];
    private static int index = -1;
    private static boolean flag = false;

    private static void kFactorizationFunction(int n, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (!flag) {
                if (n > a[i] && n % a[i] == 0) {
                    index++;
                    resultArray[index] = a[i];
                    kFactorizationFunction(n / a[i], a);
                } else if (n == a[i]) {
                    index++;
                    resultArray[index] = a[i];
                    flag = true;
                    break;
                }
                if (i == a.length - 1) {
                    break;
                }
            }
        }
    }

    private static int[] transform(int[] source) {
        int count = 0;
        for (int j = 0; j < source.length; j++) {
            if (source[j] != 0) count++;
            else break;
        }
        if (count > 0 && flag) {
            int[] temp = new int[count];
            temp[0] = 1;
            for (int i = 0; i < count; i++) {
                temp[i] = source[i];
            }
            mergeSort(temp, 0, count - 1, true);
            int[] result = new int[count + 1];
            result[0] = 1;
            for (int x = 0; x < count; x++) {
                result[x + 1] = temp[x] * result[x];
            }
            return result;
        } else return new int[]{-1};
    }

    private static void mergeSort(int[] a, int p, int r, boolean flow) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q, flow);
            mergeSort(a, q + 1, r, flow);
            merge(a, p, q, r, flow);
        }
    }

    private static void merge(int[] a, int p, int q, int r, boolean flow) {
        int n1 = q - p + 1,
                n2 = r - q;
        int[] l1 = new int[n1],
                l2 = new int[n2];
        System.arraycopy(a, p, l1, 0, n1);
        System.arraycopy(a, q + 1, l2, 0, n2);
        int i = 0, j = 0;
        for (int k = p; k < r + 1; k++) {
            if (i < l1.length && j < l2.length) {
                if ((l1[i] <= l2[j] && flow) || ((l1[i] >= l2[j] && !flow))) {
                    a[k] = l1[i];
                    i++;
                } else {
                    a[k] = l2[j];
                    j++;
                }
            } else {
                if (i == l1.length) {
                    a[k] = l2[j];
                    j++;
                } else if (j == l2.length) {
                    a[k] = l1[i];
                    i++;
                }
            }
        }
    }
}

