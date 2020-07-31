package camp.nextstep.edu.rebellion.calc;

import camp.nextstep.edu.rebellion.calc.util.NumberUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {
    private static final String DELIMITER = " ";

    private Calculator() {}

    public static int calc(String expression) {
        List<String> expressions = Arrays.asList(expression.split(DELIMITER));
        List<Integer> numbers = parseNumbers(expressions);
        List<CalculationOperator> operators = parseOperators(expressions);

        validate(numbers, operators);

        return makeResult(numbers, operators);
    }

    private static List<Integer> parseNumbers(List<String> expressions) {
        return expressions.stream()
                .filter(NumberUtil::isNumeric)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<CalculationOperator> parseOperators(List<String> expressions) {
        return expressions.stream()
                .filter(s -> !NumberUtil.isNumeric(s))
                .map(s -> CalculationOperator.of(s))
                .collect(Collectors.toList());
    }

    public static void validate(List<Integer> numbers, List<CalculationOperator> operators) {
        if(numbers.size() == operators.size() + 1) {
            return;
        }
        throw new IllegalArgumentException("수식이 올바르지 않습니다");
    }

    private static int makeResult(List<Integer> numbers, List<CalculationOperator> operators) {
        int idx = 0;
        int result = numbers.get(0);
        for(int i = 1; i < numbers.size(); i++) {
            result = operators.get(idx++).operation(result, numbers.get(i));
        }
        return result;
    }
}
