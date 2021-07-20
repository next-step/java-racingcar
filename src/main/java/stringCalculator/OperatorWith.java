package stringCalculator;

public class OperatorWith {
    double a;
    double b;
    Operator operator;

    protected OperatorWith(double a, Operator operator, double b) {
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
