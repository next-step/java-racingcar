package study;

import java.util.Arrays;
import java.util.stream.IntStream;

class StringAddCalculator {

    private static final String SPLIT_REGEX_FOR_SUM = "[,:]";

    private StringAddCalculator() {
        throw new IllegalStateException("Utility class");
    }
    public static int sum(String inputNumbers){
        if(isBlankOrNull(inputNumbers)){
            return 0;
        }
        return sumInputNumbers(getInputArray(inputNumbers));
    }

    private static int sumInputNumbers(String[] inputNumbers) {
        return covertStringArrayToIntStream(inputNumbers).sum();
    }

    private static IntStream covertStringArrayToIntStream(String[] inputNumbers) {
        return Arrays.stream(inputNumbers).mapToInt(Integer::parseInt);
    }

    private static String[] getInputArray(String inputNumbers) {
        return inputNumbers.split(SPLIT_REGEX_FOR_SUM);
    }

    private static boolean isBlankOrNull(String inputNumbers) {
        return inputNumbers == null || inputNumbers.isEmpty();
    }
}
