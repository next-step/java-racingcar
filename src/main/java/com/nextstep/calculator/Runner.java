package com.nextstep.calculator;

import java.util.List;

public class Runner {
    public static int run(String input) {
        List<String> parsed = InputParser.parse(input);

        Number result = Number.stringToNumber(parsed.get(0));

        for (int i = 1; i < parsed.size() - 1; i += 2) {
            Number secondNumber = Number.stringToNumber(parsed.get(i + 1));
            Operator operator = Operator.select(parsed.get(i));

            result = operator.operate(result, secondNumber);
        }

        return result.value();
    }
}
