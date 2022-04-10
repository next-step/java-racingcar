package calculator;

public class SumOperand {
    private final int value;

    public SumOperand(String valueString) throws NumberFormatException {
        this(Integer.parseInt(valueString));
    }

    public SumOperand(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.format("음수(%d)는 합을 구할 수 없다.", value));
        }

        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
