package calculator;

public class Operand {

    private final int value;

    private Operand(final int value) {
        if (value < 0) {
            throw new RuntimeException("피연산자는 반드시 0 이상이어야 합니다.");
        }

        this.value = value;
    }

    public static Operand from(final String token) {
        try {
            return new Operand(Integer.parseInt(token));
        } catch (NumberFormatException e) {
            throw new RuntimeException("수식을 이루는 피연산자는 반드시 숫자이어야 합니다.");
        }
    }

    public int value() {
        return this.value;
    }
}
