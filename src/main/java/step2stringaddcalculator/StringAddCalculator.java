package step2stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    static final String DEFAULT_DELIMITER = "[,:]";

    public static int splitAndSum(String reqData) throws RuntimeException {

        String inputNumbersString = reqData;

        if (checkEmptyOrNull(inputNumbersString)) {
            return 0;
        }

        String delimiter = defineDelimiter(inputNumbersString);

        inputNumbersString = checkCustomString(inputNumbersString, delimiter);
        checkMinusAndNonNumber(inputNumbersString, delimiter);

        String[] numberStringArray = changeStringNumberToArray(inputNumbersString, delimiter);

        return arrayDataSum(numberStringArray);
    }

    private static boolean checkEmptyOrNull(String reqStr) throws RuntimeException {
        return "".equals(reqStr) || reqStr == null;
    }

    private static String defineDelimiter(String reqStr) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(reqStr);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private static String checkCustomString(String inputNumbersString, String delimiter) {
        return DEFAULT_DELIMITER.equals(delimiter) ? inputNumbersString : inputNumbersString.substring(inputNumbersString.indexOf("\n") + "\n".length());
    }

    private static void checkMinusAndNonNumber(String inputNumbersString, String delimiter) throws RuntimeException {
        if (inputNumbersString.matches(".*([^0-9,:" + delimiter + "]).*")) {
            throw new RuntimeException();
        }
    }

    private static String[] changeStringNumberToArray(String inputNumbersString, String delimiter) {
        return inputNumbersString.split(delimiter);
    }

    private static int arrayDataSum(String[] array) {
        return Arrays.stream(array)
                .map(Integer::parseInt)
                .mapToInt(i -> i).sum();
    }


}
