package calculator;

import java.util.Arrays;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/")
    ;

    public String getValue() {
        return value;
    }

    private final String value;

    Operator(String value) {
        this.value = value;
    }

    public static Operator getEnum(String value) {
        return Arrays.stream(Operator.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unsupported type for %s.", value)));
    }

    public int operate(int x, int y) throws Exception {
        if(this==ADD) {
            return x + y;
        }
        if(this==SUBTRACT) {
            return x - y;
        }
        if(this==MULTIPLY) {
            return x * y;
        }
        if(this==DIVIDE) {
            return x / y;
        }
        throw new Exception();
    }
}
