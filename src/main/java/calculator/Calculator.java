package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static final String SEPARATOR = ",|:";
    public static final int CUSTOM_SEPARATOR_INPUT_BEGIN_INDEX = 4;

    public int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return 0;
        }
        return sum(getIntegerList(input));
    }

    public int sum(List<Integer> list) {
        int sum = 0;
        for (Integer value : list) {
            sum += value;
        }
        return sum;
    }

    private static List<Integer> getIntegerList(String input) {
        String[] splitInputs = split(input);
        List<Integer> list = new ArrayList<>();
        for (String splitInput : splitInputs) {
            list.add(Integer.parseInt(splitInput));
        }
        return list;
    }

    private static String[] split(String input) {
        SplitInfo splitInfo = getSplitInfo(input);
        return splitInfo.getInput().split(splitInfo.getSeparator());
    }

    private static SplitInfo getSplitInfo(String input) {
        if (isCustomSeparator(input)) {
            String customSeparator = String.valueOf(input.charAt(2));
            return new SplitInfo(input.substring(CUSTOM_SEPARATOR_INPUT_BEGIN_INDEX), customSeparator);
        }
        return new SplitInfo(input, SEPARATOR);
    }

    private static boolean isCustomSeparator(String input) {
        return input.length() >= CUSTOM_SEPARATOR_INPUT_BEGIN_INDEX &&
                input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\n';
    }
}