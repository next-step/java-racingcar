package calculator;

public class Calculator {
    public static int calculate(String expression) {

        String[] values = expression.split(" ");
        Number first = new Number(values[0]);
        Operator operator = Operator.from(values[1]);
        Number second = new Number(values[2]);

        return calculate(first, operator, second).getNumber();
    }

    private static Number calculate(Number first, Operator operator, Number second) {
        return operator.calculate(first, second);
    }
}


