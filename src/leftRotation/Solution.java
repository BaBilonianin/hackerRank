package leftRotation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static void leftRotationMain(int[] ar,int d){
        while(d>0){
            leftRotation(ar);
            d--;
        }
        for(int x: ar)
            System.out.print(x + " ");
    }

    private static void leftRotation(int[] ar){
        int temp;
        temp = ar[0];
        for(int i=0; i<ar.length-1; i++){
            ar[i]=ar[i+1];
        }
        ar[ar.length-1]=temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();

        leftRotationMain(a,d);
    }
}
