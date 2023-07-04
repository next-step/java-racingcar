package calculator;

import java.util.Arrays;

public class Calculator {

    public int calculate(String input) {
        if (input == null || input.isEmpty())
            return 0;

        return Arrays.stream(input.split(",")).mapToInt(Integer::parseInt).sum();
    }
}
