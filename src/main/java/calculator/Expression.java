package calculator;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private static final int NUMBER_START_INDEX = 0;
    private static final int OPERATOR_START_INDEX = 1;
    private static final int INTERVAL = 2;

    private final Numbers numbers;

    private final Operators operators;

    private Expression(final Numbers numbers, final Operators operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public static Expression of(String[] values) {
        return new Expression(numbersOf(values), operatorsOf(values));
    }

    private static Numbers numbersOf(String[] values) {
        List<Number> numbers = new ArrayList<>();
        int length = values.length;
        for (int i = NUMBER_START_INDEX; i < length; i += INTERVAL) {
            numbers.add(Number.valueOf(values[i]));
        }
        return new Numbers(numbers);
    }

    private static Operators operatorsOf(String[] values) {
        List<Operator> operators = new ArrayList<>();
        int length = values.length;
        for (int i = OPERATOR_START_INDEX; i < length; i += INTERVAL) {
            operators.add(Operator.symbol(values[i]));
        }
        return new Operators(operators);
    }

    public Number calculate() {
        Number number = numbers.get(NUMBER_START_INDEX);
        int count = operators.count();
        for (int i = 0; i < count; i++) {
            Operator operator = operators.get(i);
            number = operator.calculate(number, numbers.get(i + 1));
        }
        return number;
    }
}
