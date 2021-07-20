package calculator;

public class OperatorWith {
    private final double a;
    private final double b;
    private final Operator operator;

    private OperatorWith(double a, Operator operator, double b) {
        this.a = a;
        this.operator = operator;
        this.b = b;
    }

    public double calculate() {
        return operator.calculate(a, b);
    }

    public static OperatorWith of(double a, Operator operator, double b) {
        return new OperatorWith(a, operator, b);
    }
}
