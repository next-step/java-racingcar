package stringadditional;

import commons.Constant;
import exceptions.InputValueException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class StringAdditionalCalculator {
    public int splitAndSum(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Matcher matcher = Constant.CUSTOM_SPLIT_PATTERN.matcher(str);
        if(matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] values = matcher.group(2).split(customDelimiter);
            return splitValueSum(convertStringToInt(values));
        }

        String[] values = str.split(Constant.BASIC_SPLIT_REGEX);
        return splitValueSum(convertStringToInt(values));
    }

    private List<Integer> convertStringToInt(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (String value : values) {
            confirmInputCorrectValue(value);
            numbers.add(Integer.parseInt(value));
        }

        return numbers;
    }

    private int splitValueSum(List<Integer> values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }

        return result;
    }

    private void confirmInputCorrectValue(String value) throws InputValueException {
        if(!value.matches(Constant.NUMBER_RANGE_REGEX)) {
            throw new InputValueException(Constant.NEGATIVE_OR_NON_NUMERIC_ERR_MSG);
        }
    }
}
