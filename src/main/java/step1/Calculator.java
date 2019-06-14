package step1;

import step1.enums.OperationSymbol;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step1.util.StringUtil.isConsistOnlyWhiteSpace;
import static step1.validator.Validator.validateInput;
import static step1.validator.Validator.validateToken;

public class Calculator {

    public int process(String input) {

        validateInput(input);
        List<String> tokens = tokenize(input);
        validateToken(tokens);

        return calculate(tokens);
    }

    List<String> tokenize(String input) {

        return IntStream.range(0, input.length())
                .mapToObj(input::charAt)
                .map(String::valueOf)
                .filter(token -> !isConsistOnlyWhiteSpace(token))
                .collect(Collectors.toList());
    }

    public int calculate(List<String> tokens) {

        int result = Integer.valueOf(tokens.get(0));

        for (int i = 1; i < tokens.size(); i += 2) {
            result = calculate(tokens.get(i), result, Integer.valueOf(tokens.get(i + 1)));
        }

        return result;
    }

    private int calculate(String symbol, int num1, int num2) {

        return OperationSymbol.from(symbol).apply(num1, num2);
    }
}
