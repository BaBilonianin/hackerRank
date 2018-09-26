package dynamicArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created on 26.09.2018.
 */
public class Solution {

    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0, q, x, y;
        ArrayList<Integer> temp;
        ArrayList<Integer> resultArray = new ArrayList<>();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(i, new ArrayList<>());
        }
        for (int i = 0; i < queries.size(); i++) {
            q = queries.get(i).get(0);
            x = queries.get(i).get(1);
            y = queries.get(i).get(2);

            temp = a.get((x ^ lastAnswer) % n);

            if (queries.get(i).get(0) == 1) {
                temp.add(y);
            } else if (queries.get(i).get(0) == 2) {
//                if (temp.size() != 0) {
                lastAnswer = temp.get(queries.get(i).get(2) % temp.size());
                System.out.println(lastAnswer);
                resultArray.add(lastAnswer);
//                }
            }
        }
        return resultArray;
    }

//    public static void main(String[] args) {
//        int n = 2;
//        List<List<Integer>> source = new ArrayList<>();
//        source.add(new ArrayList<>(Arrays.asList(1, 0, 5)));
//        source.add(new ArrayList<>(Arrays.asList(1, 1, 7)));
//        source.add(new ArrayList<>(Arrays.asList(1, 0, 3)));
//        source.add(new ArrayList<>(Arrays.asList(2, 1, 0)));
//        source.add( new ArrayList<>(Arrays.asList(2, 1, 1)));
//
//        dynamicArray(n,source);
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

//        bufferedWriter.write(
//                result.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );
//        bufferedWriter.close();

        bufferedReader.close();
    }
}