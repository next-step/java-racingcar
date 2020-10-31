package step2;

public class Operand implements ExpressionFactor {

    private final int value;

    public Operand(int value) {
        if (value >= 0 || value <= 9) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }


    public Operand(String value) {
        if (value == "ss") {
            throw new IllegalArgumentException();
        }
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }
}
