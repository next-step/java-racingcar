import java.util.function.IntBinaryOperator;

public enum IntOperator {
    ADD((right, left) -> right + left),
    SUBTRACT((right, left) -> right - left),
    MULTIPLY((right, left) -> right * left),
    DIVIDE((right, left) -> right / left);

    IntBinaryOperator operate;

    IntOperator(IntBinaryOperator operate) {
        this.operate = operate;
    }

    public int operate(int left, int right) {
        return operate.applyAsInt(left, right);
    }

    public static IntOperator of(String sign) {
        switch (sign) {
            case "+":
                return IntOperator.ADD;
            case "-":
                return IntOperator.SUBTRACT;
            case "*":
                return IntOperator.MULTIPLY;
            case "/":
                return IntOperator.DIVIDE;
        }
        throw new IllegalArgumentException();
    }
}
