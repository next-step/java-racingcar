package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static final String SEPARATOR = ",|:";

    public int splitAndSum(String input) {
        if (input == null || input.isBlank()) {
            return Number.ZERO.getValue();
        }
        return sum(getIntegerList(input));
    }

    public int sum(List<Integer> list) {
        int sum = Number.ZERO.getValue();
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
            return String.valueOf(input.charAt(Number.TWO.getValue()));
        }
        return SEPARATOR;
    }

    private static String getValueToSplit(String input) {
        if(isCustomSeparator(input)) {
            return input.substring(Number.FOUR.getValue());
        }
        return input;
    }

    private static boolean isCustomSeparator(String input) {
        return input.length() >= Number.FOUR.getValue() &&
                input.charAt(Number.ZERO.getValue()) == '/' &&
                input.charAt(Number.ONE.getValue()) == '/' &&
                input.charAt(Number.THREE.getValue()) == '\n';
    }
}