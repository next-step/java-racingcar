package step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {
    public static CalculatorNumber calculate(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("빈 문자열 혹은 null은 입력할 수 없습니다.");
        }

        String[] elements = expression.split(" ");

        List<CalculatorNumber> operands = IntStream.range(0, elements.length)
                .filter(n -> n % 2 == 0)
                .mapToObj(i -> new CalculatorNumber(elements[i]))
                .collect(Collectors.toList());

        List<Operator> operators = IntStream.range(0, elements.length)
                .filter(n -> n % 2 != 0)
                .mapToObj(i -> Operator.findByValue(elements[i]))
                .collect(Collectors.toList());

        CalculatorNumber result = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).operate(result, operands.get(i + 1));
        }

        return result;
    }
}
