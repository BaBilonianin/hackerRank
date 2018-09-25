package mergeSort;

import java.util.Arrays;

/**
 * Created on 23.09.2018.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] sourceArr = {5,4,3,2,1};
//        int[] sourceArr = {1, 4, 5, 1, 3};
        mergeSort(sourceArr, 0, sourceArr.length - 1);
//        merge(sourceArr, 0, 2, 4);
        return;
    }

    static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
            System.out.println(Arrays.toString(a));
        }
    }

    private static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1,
                n2 = r - q;
        int[] l1 = new int[n1],
                l2 = new int[n2];
        System.arraycopy(a, p, l1, 0, n1);
        System.arraycopy(a, q + 1, l2, 0, n2);
        int i = 0, j = 0;
        for (int k = p; k < r + 1; k++) {
            if (i < l1.length && j < l2.length) {
                if (l1[i] <= l2[j]) {
                    a[k] = l1[i];
                    i++;
                } else {
                    a[k] = l2[j];
                    j++;
                }
            }else{
                if(i==l1.length) {
                    a[k] = l2[j];
                    j++;
                }else if(j==l2.length){
                    a[k] = l1[i];
                    i++;
                }
            }
        }
    }
}
