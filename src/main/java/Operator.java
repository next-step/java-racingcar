import java.util.Arrays;

public enum Operator {
    PLUS("+");

    private final String opChar;

    Operator(String opChar) {
        this.opChar = opChar;
    }

    public static Operator fromOpChar(String opChar) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.opChar.equals(opChar))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Wrong operator: " + opChar));
    }

    @Override
    public String toString() {
        return opChar;
    }
}