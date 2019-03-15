package calculator;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class AddStringCalculator {

    public static int addCalculator(String input) {
        List<String> inputs = new ArrayList<>();
        List<Integer> intInput = new ArrayList<>();

        inputs = seperatorInput(input);


        add(inputs);


        return 20;
    }

    private static int add(List<String> inputs) {
        int sum = 0;

        for (String value : inputs) {
            sum += Integer.parseInt(value);
        }

        return sum;
    }

    public static List<String> seperatorInput(String input) {
        List<String> inputs = new ArrayList<>();

        for (String value : input.split(",")) {
            inputs.add(value);
        }

        return inputs;
    }

    public static void checkInputValidation(String input) {

        if(input.length() == 1) {
            throw new IllegalArgumentException();
        }
        if (StringUtils.isEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }
}
