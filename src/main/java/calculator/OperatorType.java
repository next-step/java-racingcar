package calculator;

public enum OperatorType {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private String mValue;

    OperatorType(String value) {
        this.mValue = value;
    }

    public boolean isEqual(String text) {
        return mValue.equals(text);
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
