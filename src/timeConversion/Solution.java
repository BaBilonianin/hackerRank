package timeConversion;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 18.09.2018.
 */
public class Solution {
    public static void main(String [] args) throws Exception {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = parseFormat.parse("07:05:45PM");
        System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
    }
}

