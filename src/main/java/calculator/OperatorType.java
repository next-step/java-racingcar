package calculator;

import com.sun.istack.internal.Nullable;

public enum OperatorType {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private String mValue;

    OperatorType(String value) {
        this.mValue = value;
    }

    public boolean isEqual(String text) {
        return mValue.equals(text);
    }

    @Nullable
    public Number calculate(@Nullable Number firstOperand, @Nullable Number secondOperand) {
        ValidationUtils.assertNull(firstOperand);
        ValidationUtils.assertNull(secondOperand);

        switch (this) {
            case PLUS:
                return firstOperand.plus(secondOperand);

            case MINUS:
                return firstOperand.minus(secondOperand);

            case MULTIPLY:
                return firstOperand.multiply(secondOperand);

            case DIVIDE:
                return firstOperand.divide(secondOperand);

            default:
                return null;
        }
    }

    public static OperatorType find(String text) {
        for (OperatorType each : OperatorType.values()) {
            if (each.isEqual(text)) {
                return each;
            }
        }

        return null;
    }
}
