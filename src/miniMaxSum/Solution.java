package miniMaxSum;

import java.io.IOException;

/**
 * Created on 17.09.2018.
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        int arr[] = new int[]{7, 69, 2, 221, 8974};
//        miniMaxSum(arr);

            /*
             * Write your code here.
             */
            int[] grades={73,68,38,33};
            for(int i=0;i<grades.length;i++){
                if(grades[i]>37){
                    if((((grades[i]/5+1)*5)-grades[i])<3)
                        grades[i]=(i/5+1)*5;
                }
            }
        for (int i:grades
             ) {
            System.out.println(i);
        }
    }

    static void miniMaxSum(int[] arr) {
        long min=arr[0], max=arr[0], sum=0;
        for(int i=0;i<5;i++){
            if(min>(long)arr[i]) min=(long)(arr[i]);
            if(max<(long)arr[i]) max=(long)(arr[i]);
            sum+=(long)arr[i];
        }
        System.out.println((sum - max) + " " + (sum - min));
//        long l = 9 + 299;
//        System.out.println(l);
    }
}
