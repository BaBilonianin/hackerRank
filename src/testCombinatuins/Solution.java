package testCombinatuins;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created on 21.09.2018.
 */
public class Solution {
    public static void main(String[] args) {
        int[] sourceArr = {1 , 2 , 3};
        printAllCOmbinations(sourceArr);
    }

    private static void printAllCOmbinations(int[] sourceArr) {
        //System.out.println(showAllCombinations(sourceArr));
        showAllCombinations(sourceArr);
    }

    private static String showAllCombinations(int[] a) {
        String result= "";
        for (int i=0;i<a.length;i++) {
            for (int j = 0; j < a.length; j++) {
                for (int t = 0; t < a.length; t++) {
                    result= result + a[i] + a[j] + a[t] + " ";
                    System.out.print(result + " ");
                    result = "";
                }
            }
        }
        return result;
    }
}
