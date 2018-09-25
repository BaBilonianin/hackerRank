package kFactorization;

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
        System.out.print(d);
        int n = 924000000;
        int[] a = {2, 3, 5, 7, 11, 13, 17, 19};
        mergeSort(a, 0, a.length - 1);
        int[] result = kFactorization(n, a);
        for (int i : result)
            System.out.print(i + " ");
        System.out.print(d.getTime() - System.currentTimeMillis());
    }

    private static int[] kFactorization(int n, int[] a) {
        mergeSort(a, 0, a.length - 1);
        kFactorizationFunction(n, a);
        if (sortArrays(succesArrays)) {
            return transform(succesArrays.get(0));
        } else return new int[]{-1};
    }

    private static int[] resultArray = new int[20];
    private static int index = -1, indexGlobal = -1, temp = -1, minResultLength;
    private static ArrayList<int[]> succesArrays = new ArrayList<int[]>();


    private static boolean sortArrays(ArrayList<int[]> successArrays) {
        int minLenght = -1;
        int[] z;
        if (successArrays.size() > 0) {
            //----------1 step. find arrays with max length
            if (successArrays.size() != 1) {
                for (int x = 0; x < successArrays.size(); x++) {
                    if (minLenght == -1 || minLenght > successArrays.get(x).length) {
                        minLenght = successArrays.get(x).length;
                        x = -1;
                    } else if (minLenght < successArrays.get(x).length) {
                        successArrays.remove(x);
                        x--;
                    }
                }
            }
            //-------------2 step. sort arrays with min length
            if (successArrays.size() != 1)
                successArrays.sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1.length < o2.length) return -1;
                        if (o1.length > o2.length) return 1;
                        for (int i = 0; i < o1.length; i++) {
                            if (o1[i] < o2[i]) return -1;
                            if (o1[i] > o2[i]) return 1;
                        }
                        return 0;
                    }
                });
            return true;
        } else return false;
    }

    private static void kFactorizationFunction(int n, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (n < a[i]) {
                if (index > 0) {
                    resultArray[index] = 0;
                    index--;
                }
                break;
            } else if (n > a[i] && n % a[i] == 0) {
                index++;
                resultArray[index] = a[i];
                kFactorizationFunction(n / a[i], a);
            } else if (n == a[i]) {
                index++;
                resultArray[index] = a[i];

                minResultLength = resultArray.length;
                indexGlobal++;
                succesArrays.add(getNewArray(resultArray));

                resultArray[index] = 0;
                resultArray[index - 1] = 0;
                index--;
                index--;
                break;
            }
            if (i == a.length - 1) {
                if (index > -1) {
                    resultArray[index] = 0;
                    index--;
                }
            }
        }
    }

//    private static void kFactorizationFunction(int n, int[] a) {
//        for (int i = 0; i < a.length; i++) {
//            if (n < a[i]) {
//                if (index > 0) {
//                    resultArray[index] = 0;
//                    index--;
//                }
//                break;
//            } else if (n > a[i] && n % a[i] == 0) {
//                index++;
//                resultArray[index] = a[i];
//                kFactorizationFunction(n / a[i], a);
//            } else if (n == a[i]) {
//                index++;
//                resultArray[index] = a[i];
//
////                minResultLength = resultArray.length;
//                indexGlobal++;
//                succesArrays.add(getNewArray(resultArray));
//
//                resultArray[index] = 0;
//                resultArray[index - 1] = 0;
//                index--;
//                index--;
//                break;
//            }
//            if (i == a.length - 1) {
//                if (index > -1) {
//                    resultArray[index] = 0;
//                    index--;
//                }
//            }
//        }
//    }


    private static int[] transform(int[] source) {
        int[] result = new int[source.length + 1];
        result[0] = 1;
        for (int i = 0; i < source.length; i++) {
            result[i + 1] = source[i] * result[i];
        }
        return result;
    }

    private static int[] getNewArray(int[] source) {
        int count = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] != 0)
                count++;
            else break;
        }
        int[] result = new int[count];
        for (int j = 0; j < count; j++) {
            result[j] = source[j];
        }
        return result;
    }

    private static int[] subbArray(int[] a, int g, int i) {
        int[] result = new int[i - g + 1];
        for (int x = 0; x < i - g + 1; x++) {
            result[x] = a[x + g];
        }
        return result;
    }

    private static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(a, p, q);
            mergeSort(a, q + 1, r);
            merge(a, p, q, r);
            //System.out.println(Arrays.toString(a));
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

