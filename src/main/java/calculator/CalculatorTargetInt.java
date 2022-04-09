package calculator;

public class CalculatorTargetInt {
    private final int value;

    public CalculatorTargetInt(String valueString) {
        try {
            this.value = Integer.parseInt(valueString);

            if (value < 0) {
                throw new IllegalArgumentException(String.format("음수(%d)는 합을 구할 수 없다.", value));
            }

        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(String.format("문자'(%s)'는 합을 구할 수 없다.", valueString));
        }
    }

    public int getValue() {
        return value;
    }
}
