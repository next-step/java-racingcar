package calculator.domain;

public class Operator {

    private final String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public String value() {
        return operator;
    }

    public int calculate (int total, int operand) {
        switch (operator) {
            case "+":
                return total + operand;
            case "-":
                return total - operand;
            case "/":
                return total / operand;
            case "*":
                return total * operand;
        }
        return -1;
    }
}
