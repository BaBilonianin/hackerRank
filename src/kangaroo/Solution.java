package kangaroo;

public class Solution {
    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        boolean condition = (x1 - x2) > 0;
        int i = 1;
        if ((x1 < x2 && v1 <= v2) || (x1 > x2 && v1 >= v2))
            return "NO";

        while ((x1 - x2) > 0 == condition) {
            x1 = x1 + i * v1;
            x2 = x2 + v2 * i;
            if (x1 == x2)
                return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        int[] source = new int[]{43, 2, 70, 2};
        System.out.println(kangaroo(source[0], source[1], source[2], source[3]));
    }
}
