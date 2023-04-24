package calculator;

import java.util.ArrayList;
import java.util.List;

import static calculator.CustomSeparator.*;

public class Calculator {

    private static final String SEPARATOR = ",|:";

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

    private List<Integer> getIntegerList(String input) {
        String[] splitInputs = split(input);
        List<Integer> list = new ArrayList<>();
        for (String splitInput : splitInputs) {
            list.add(new PositiveInteger(splitInput).getNumber());
        }
        return list;
    }

    private String[] split(String input) {
        String separator = getSeparator(input);
        return getValueToSplit(input).split(separator);
    }

    private String getSeparator(String input) {
        if (isCustomSeparator(input)) {
            return String.valueOf(input.charAt(SEPARATOR_INDEX.value()));
        }
        return SEPARATOR;
    }

    private String getValueToSplit(String input) {
        if (isCustomSeparator(input)) {
            return input.substring(INPUT_BEGIN_INDEX.value());
        }
        return input;
    }

    private boolean isCustomSeparator(String input) {
        return input.length() >= INPUT_BEGIN_INDEX.value() &&
                input.charAt(CHAR_INDEX_BEFORE_SECOND_SEPARATOR.value()) == '/' &&
                input.charAt(CHAR_INDEX_BEFORE_SEPARATOR.value()) == '/' &&
                input.charAt(CHAR_INDEX_AFTER_SEPARATOR.value()) == '\n';
    }
}