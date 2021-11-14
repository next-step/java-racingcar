package step2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {
    private final List<CalculatorNumber> operands;
    private final List<Operator> operators;

    Expression(List<CalculatorNumber> operands, List<Operator> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public static Expression from(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("빈 문자열 혹은 null은 입력할 수 없습니다.");
        }

        String[] elements = expression.split(" ");

        List<CalculatorNumber> operands = IntStream.range(0, elements.length)
                .filter(n -> n % 2 == 0)
                .mapToObj(i -> CalculatorNumber.parse(elements[i]))
                .collect(Collectors.toList());

        List<Operator> operators = IntStream.range(0, elements.length)
                .filter(n -> n % 2 != 0)
                .mapToObj(i -> Operator.findByValue(elements[i]))
                .collect(Collectors.toList());

        return new Expression(operands, operators);
    }

    public CalculatorNumber compute() {
        CalculatorNumber result = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            CalculatorNumber operand = operands.get(i + 1);
            result = operators
                    .get(i)
                    .operate(result, operand);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expression that = (Expression) o;
        return operands.equals(that.operands) && operators.equals(that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands, operators);
    }
}
