package calculator;

import java.util.ArrayList;
import java.util.List;

import static calculator.CustomSeparator.*;

public class Calculator {

    public static final String SEPARATOR = ",|:";
    public static final int ZERO = 0;

    public int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return ZERO;
        }
        return sum(getIntegerList(input));
    }

    public int sum(List<Integer> list) {
        int sum = ZERO;
        for (Integer value : list) {
            sum += value;
        }
        return sum;
    }

    private static List<Integer> getIntegerList(String input) {
        String[] splitInputs = split(input);
        List<Integer> list = new ArrayList<>();
        for (String splitInput : splitInputs) {
            list.add(new PositiveInteger(splitInput).getNumber());
        }
        return list;
    }

    private static String[] split(String input) {
        String separator = getSeparator(input);
        return getValueToSplit(input).split(separator);
    }

    private static String getSeparator(String input) {
        if (isCustomSeparator(input)) {
            return String.valueOf(input.charAt(SEPARATOR_INDEX.getValue()));
        }
        return SEPARATOR;
    }

    private static String getValueToSplit(String input) {
        if (isCustomSeparator(input)) {
            return input.substring(INPUT_BEGIN_INDEX.getValue());
        }
        return input;
    }

    private static boolean isCustomSeparator(String input) {
        return input.length() >= INPUT_BEGIN_INDEX.getValue() &&
                input.charAt(CHAR_INDEX_BEFORE_SECOND_SEPARATOR.getValue()) == '/' &&
                input.charAt(CHAR_INDEX_BEFORE_SEPARATOR.getValue()) == '/' &&
                input.charAt(CHAR_INDEX_AFTER_SEPARATOR.getValue()) == '\n';
    }
}