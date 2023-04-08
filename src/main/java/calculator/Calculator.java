package calculator;

import java.util.ArrayList;
import java.util.List;

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
            list.add(new PositiveInteger(splitInput).getNumber());
        }
        return list;
    }

    private static String[] split(String input) {
        String separator = getSeparator(input);
        return getValueToSplit(input).split(separator);
    }

    private static String getSeparator(String input) {
        if(isCustomSeparator(input)) {
            return String.valueOf(input.charAt(2));
        }
        return SEPARATOR;
    }

    private static String getValueToSplit(String input) {
        if(isCustomSeparator(input)) {
            return input.substring(CUSTOM_SEPARATOR_INPUT_BEGIN_INDEX);
        }
        return input;
    }

    private static boolean isCustomSeparator(String input) {
        return input.length() >= CUSTOM_SEPARATOR_INPUT_BEGIN_INDEX &&
                input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\n';
    }
}