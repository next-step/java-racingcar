package step2;

public class Operand implements ExpressionFactor {

    private final int value;

    public Operand(int value) {
        this.value = value;
    }

    public Operand(String value) {
        try {
            this.value = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자가 아님", e);
        }
    }

    public int getValue() {
        return value;
    }
}
