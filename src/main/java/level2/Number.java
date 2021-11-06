package level2;

public class Number {
    private int value;
    public Number(String input) {
        value = Integer.parseInt(input);
    }

    public int getValue() {
        return value;
    }

    public int calculate(Operator operator, Number number2) {
        return operator.calculate(this, number2);
    }
}
