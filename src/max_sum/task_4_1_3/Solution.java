package max_sum.task_4_1_3;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created on 14.09.2018.
 */
public class Solution {
    private int countBrute = 0;
    private int countSub = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.start();
    }

    private void start() {
        completeTaskManyTimes(300);
    }

    private void completeTaskManyTimes(int times) {
        ArrayList<Integer> a = new ArrayList<>();
        //Random random = new Random(0);
        for (int i = 0; i < times; i++) {
            countSub = 0;
            countBrute = 0;
//            a.add(random.nextInt());
            a.add(5);
            MyResult maxArray = findMaxSubArray(a, 0, a.size() - 1);
            printResult(maxArray);
            maxArray = bruteForceMethod(a);
            printResult(maxArray);
            printCounts(i);
        }
    }

    private void printCounts(int i) {
        System.out.println("countBrute = " + countBrute + "  CountSub = " + countSub + "   " + i);
    }

    private void printResult(MyResult maxArray) {
        System.out.println(maxArray.max_left + " " + maxArray.max_right + " " + maxArray.sum);
    }

    private MyResult findMaxCrossSubarray(ArrayList<Integer> A, int low, int mid, int high) {
        int sum = 0, left_sum = 0;
        int max_left = 0, max_right = 0;
        int right_sum = 0;
        for (int i = mid; i >= low; i--) {
            countSub++;
            sum = sum + A.get(i);
            if (sum > left_sum) {
                left_sum = sum;
                max_left = i;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            countSub++;
            sum = sum + A.get(j);
            if (sum > right_sum) {
                right_sum = sum;
                max_right = j;
            }
        }
        return new MyResult(max_left, max_right, left_sum + right_sum);
    }

    private MyResult findMaxSubArray(ArrayList<Integer> a, int low, int high) {
        MyResult leftResult, rightRes, crossRes;
        if (high == low) {
            countSub++;
            return new MyResult(low, high, a.get(low));
        } else {
            int mid = (int) Math.floor((low + high) >> 1);
            leftResult = findMaxSubArray(a, low, mid);
            rightRes = findMaxSubArray(a, mid + 1, high);
            crossRes = findMaxCrossSubarray(a, low, mid, high);
            countSub += 4;
            if (leftResult.sum >= rightRes.sum && leftResult.sum >= crossRes.sum) {
                countSub++;
                return leftResult;
            } else if (rightRes.sum >= leftResult.sum && rightRes.sum >= crossRes.sum) {
                countSub++;
                return rightRes;
            } else {
                countSub++;
                return crossRes;
            }
        }
    }

    private MyResult bruteForceMethod(ArrayList<Integer> a) {
        int sum, maxSum = 0;
        int left_max = 0, right_max = 0;
        for (int i = 0; i < a.size(); i++) {
            countBrute++;
            sum = 0;
            for (int j = i; j < a.size(); j++) {
                countBrute++;
                sum = sum + a.get(j);
                if (sum > maxSum) {
                    maxSum = sum;
                    right_max = j;
                    left_max = i;
                }
            }
        }

        return new MyResult(left_max, right_max, maxSum);
    }
}
