package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPlusCalculator {

    public static int sumOfNumbers(String s) {
        if (isEmptyOrNull(s)) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            return sum(split(m.group(2), m.group(1)));
        }
        return sum(split(s, ",|:"));
    }

    private static int sum(String[] values) {
        int result = 0;
        for (String s : values) {
            if (isNonNegativeInteger(s)) {
                result += Integer.parseInt(s);
            }
        }
        return result;
    }

    private static boolean isNonNegativeInteger(String s) {
        if (s.matches("[+-]?\\d*(\\.\\d+)?") && Integer.parseInt(s) >= 0) {
            return true;
        }
        throw new RuntimeException();
    }

    private static String[] split(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static boolean isEmptyOrNull(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        return false;
    }

//    public static int run(String s) {
//        int result = 0;
//
//        if (s == null || s.isEmpty()) {
//            return result;
//        }
//
//        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
//        if (m.find()) {
//            String customDelimiter = m.group(1);
//            String[] tokens = m.group(2).split(customDelimiter);
//            for (String s1 : tokens) {
//                if (s1.matches("[+-]?\\d*(\\.\\d+)?") && Integer.parseInt(s1) >= 0) {
//                    result += Integer.parseInt(s1);
//                } else {
//                    throw new RuntimeException();
//                }
//            }
//        } else {
//            String[] sp2 = s.split(",|:");
//            for (String s2 : sp2) {
//                if (s2.matches("[+-]?\\d*(\\.\\d+)?") && Integer.parseInt(s2) >= 0) {
//                    result += Integer.parseInt(s2);
//                } else {
//                    throw new RuntimeException();
//                }
//            }
//        }
//        return result;
//    }
}
