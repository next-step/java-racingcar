package 문자열_덧셈_계산기_2단계;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {


    public static int splitAndSum(String reqData) throws RuntimeException {
        String[] numberStringArray;
        String delimiter = "";
        String reqStr = reqData;

        if (checkEmptyOrNull(reqStr)) {
            return 0;
        }

        delimiter = defineDelimiter(reqStr);

        if (!delimiter.isEmpty()) {
            reqStr = removeCustomString(reqStr);
        }

        checkMinusAndNonNumber(reqStr, delimiter);
        numberStringArray = changeStringNumberToArray(reqStr, delimiter);

        return arrayDataSum(numberStringArray);
    }


    private static String[] changeStringNumberToArray(String reqStr, String delimiter) {
        return reqStr.split(delimiter);
    }


    private static int arrayDataSum(String[] array) {
        return Arrays.stream(array)
                .map(Integer::parseInt)
                .mapToInt(i -> i).sum();
    }


    private static String removeCustomString(String reqStr) {
        return reqStr.substring(reqStr.indexOf("\n") + "\n".length());
    }

    private static String defineDelimiter(String reqStr) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(reqStr);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "[,:]";
    }

    private static void checkMinusAndNonNumber(String reqStr, String delimiter) throws RuntimeException {
        if (reqStr.matches(".*([^0-9,:" + delimiter + "]).*")) {
            throw new RuntimeException();
        }
    }

    private static boolean checkEmptyOrNull(String reqStr) throws RuntimeException {
        return "".equals(reqStr) || reqStr == null;
    }

}
