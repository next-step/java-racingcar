package camp.nextstep.edu.calculator;

import java.util.Arrays;

public enum OperatorType {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String sign;

    OperatorType(String sign) {
        this.sign = sign;
    }

    public static OperatorType from(String value) {
        final OperatorType[] types = OperatorType.values();
        return Arrays.stream(types)
                .filter(type -> type.sign.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("'value' is not supported. value:" + value));
    }

    @Override
    public String toString() {
        return "OperatorType(name=" + this.name() + ", sign=" + this.sign + ")";
    }
}
