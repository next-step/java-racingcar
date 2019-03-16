package calculator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class StringAddCalculator {
    public int calculate(String input) {
        if (StringUtils.isBlank(input)) {
            return 0;
        }

        if (NumberUtils.isNumber(input)) {
            return Integer.parseInt(input);
        }

        String[] inputs = getInputNumbers(input);

        if (inputs.length < 2) {
            throw new RuntimeException();
        }

        return addInputs(inputs);
    }

    private String[] getInputNumbers(String input) {
        String regex = ",|:";

        if (input.indexOf("\n") != -1) {
            regex = findRegexWord(input);
            input = input.split("\n")[1];
        }

        return input.split(regex);
    }

    private String findRegexWord(String input) {
        if (input.startsWith("//")) {
            String[] inputs = input.split("\n");
            return inputs[0].substring(2);
        }

        return ",|:";
    }

    private int addInputs(String[] inputs) {
//        return Arrays.stream(inputs).mapToInt(it -> Integer.parseInt(it)).sum();
        int result = 0;

        for (int i = 0; i < inputs.length; i++) {
            int number = Integer.parseInt(inputs[i]);
            result = sum(result, number);
        }

        return result;
    }

    private int sum(int result, int number) {
        if (number < 0) {
            throw new RuntimeException();
        }

        return result + number;
    }
}
