package calculator;

public class Operand {
    private final static int ZERO = 0;

    private final int value;

    public Operand(String value) throws NumberFormatException {
        this(Integer.parseInt(value));
    }

    public Operand(int value) {
        validatePositive(value);
        this.value = value;
    }

    public Operand() {
        this(ZERO);
    }

    private void validatePositive(int value) {
        if (isNegative(value)) {
            throw new IllegalArgumentException(String.format("음수(%d)는 합을 구할 수 없다.", value));
        }
    }

    private boolean isNegative(int value) {
        return value < ZERO;
    }

    public int getValue() {
        return value;
    }

    public Operand add(Operand operand) {
        return new Operand(this.value + operand.getValue());
    }
}
