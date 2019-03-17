package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class AddStringCalculator {

    public static int addCalculator(String input) {

        checkInputValidation(input);

        List<String> inputs = splitInput(input);

        return add(inputs);
    }

    private static int add(List<String> inputs) {
        int sum = 0;

        for (String value : inputs) {
            sum += Integer.parseInt(value);
        }

        return sum;
    }

    public static List<String> splitInput(String input) {
        List<String> inputs = new ArrayList<>();

        for (String value : input.split(",|/")) {
            checkMinusInput(value);
            inputs.add(value);
        }

        return inputs;
    }

    public static void checkMinusInput(String input) {
        if (StringInput.isMinusInput(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkInputValidation(String input) {

        if (StringInput.isMoreThanOne(input)) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }
}
