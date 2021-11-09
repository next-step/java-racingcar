package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {

    private StringCalculator() { }

    public static long calculate(String expression) {
        if (Objects.isNull(expression) || expression.equals("")) {
            throw new IllegalArgumentException("공백 or null 표현은 계산이 불가능합니다.");
        }

        List<String> items = Arrays.asList(expression.split(" "));
        List<Long> operands = getOperands(items);
        List<String> operatorSymbols = getOperatorSymbols(items);

        Long result = operands.get(0);
        for (int i = 1; i < operands.size(); i++) {
            BinomialExpression binomialExpression =
                    new BinomialExpression(result, operands.get(i), operatorSymbols.get(i - 1));
            result = binomialExpression.calculate();
        }
        return result;
    }

    private static List<Long> getOperands(List<String> items) {
        return IntStream.range(0, items.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(items::get)
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    private static List<String> getOperatorSymbols(List<String> items) {
        return IntStream.range(0, items.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(items::get)
                .collect(Collectors.toList());
    }
}
