package calculator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringAddCalculator {

    private static final int ZERO = 0;
    private static final Set<String> DELIMITERS = new HashSet<>(Arrays.asList(",", ":"));

    public int splitAndSum(String inputString) {
        if (isInvalidInput(inputString)) {
            return ZERO;
        }
        if (isUseCustomDelimeter(inputString)) {
            inputString = trimCustomDelemeterString(inputString);
        }
        String[] split = inputString.split(toRegexString(DELIMITERS));
        return getSum(getInts(split));

    }

    private static String trimCustomDelemeterString(String inputString) {
        String s = Character.toString(inputString.charAt(2));
        DELIMITERS.add(s);
        inputString = inputString.substring(4);
        return inputString;
    }

    private static boolean isUseCustomDelimeter(String inputString) {
        return inputString.charAt(0) == '/' && inputString.charAt(1) == '/' && inputString.charAt(3) == '\n';
    }

    private String toRegexString(Set<String> delimeters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String delimeter : delimeters) {
            stringBuilder.append(delimeter);
            stringBuilder.append("|");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private static int getSum(int[] ints) {
        int sum = 0;
        for (int temp : ints) {
            sum += temp;
        }
        return sum;
    }

    private static int[] getInts(String[] split) {
        int[] ints = new int[split.length];

        for(int i = 0; i< split.length ; i++ ) {
            int i1 = Integer.parseInt(split[i]);
            if(i1 < 0) {
                throw new RuntimeException();
            }
            ints[i] = i1;
        }
        return ints;
    }

    private boolean isInvalidInput(String inputString) {
        return inputString == null || inputString.isBlank();
    }

    //private


}
