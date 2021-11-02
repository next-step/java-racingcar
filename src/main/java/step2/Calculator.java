package step2;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Calculator {

    private static final String DELIMITER = " ";

    public int calculate(String expression) {
        checkNotEmpty(expression);

        List<String> elements = stream(expression.split(DELIMITER))
                .collect(Collectors.toList());

        List<Integer> numbers = ParserFactory.getParser(Integer.class).parse(elements);
        List<Operator> operators = ParserFactory.getParser(Operator.class).parse(elements);

        return calculate(numbers, operators);
    }

    private int calculate(List<Integer> numbers, List<Operator> operators) {
        verifyCanBeCalculated(numbers, operators);

        int result = numbers.remove(0);

        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            Operator operator = operators.get(i);
            result = operator.operate(result, number);
        }
        return result;
    }

    private void verifyCanBeCalculated(List<Integer> numbers, List<Operator> operators) {
        if (numbers.size() < 1) {
            throw new IllegalArgumentException("숫자는 한개 이상이어야 합니다.");
        }

        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException("[숫자 개수 = 연산자 개수 + 1] 이어야 합니다.");
        }
    }

    private void checkNotEmpty(String expression) {
        if (expression == null || expression.equals("")) {
            throw new IllegalArgumentException("expression is required");
        }
    }

}
