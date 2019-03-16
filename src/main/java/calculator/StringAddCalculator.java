package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {

    static int calc(String inputText) {
        if (StringUtils.isEmpty(inputText)) {
            return 0;
        }

        return addAll(split(inputText));
    }

    private static int addAll(List<Integer> numbers) {
        int result = 0;

        for (Integer number : numbers) {
            result += number;
        }

        return result;
    }

    static List<Integer> split(final String inputText, final String delimiter) {
        String[] inputNums = inputText.split(delimiter);
        List<Integer> numbers = new ArrayList<>();

        for (String inputNum : inputNums) {
            numbers.add(Integer.parseInt(inputNum));
        }

        return numbers;
    }

    static List<Integer> split(final String inputText) {
        return split(inputText, ",|:");
    }
}
