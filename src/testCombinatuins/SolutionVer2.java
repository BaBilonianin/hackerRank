package testCombinatuins;

/**
 * Created on 21.09.2018.
 */
public class SolutionVer2 {

    static String result = "";

    public static void main(String[] args) {

        int[] sourceArr = {1, 2, 3};
        printAllCOmbinations(sourceArr);
    }

    private static void printAllCOmbinations(int[] sourceArr) {
        //System.out.println(showAllCombinations(sourceArr));
        showAllCombinations(sourceArr, sourceArr.length);
    }

    private static void showAllCombinations(int[] a, int k) {
        int n = k - 1;
        for (int i = 0; i < a.length; i++) {
            if (n == 0) {
                result = result + a[i];
                System.out.println(result + "\n");
                result = result.substring(0, result.length() - 1);
            } else {
                result = result + a[i];
                showAllCombinations(a, n);
            }
            if (i == a.length - 1 && result.length()!=0) {
                result = result.substring(0,result.length() - 1);
                n++;
            }
        }
    }
}
