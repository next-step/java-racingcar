package study;

import java.util.Arrays;
import java.util.Optional;

public enum OperationType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String sign;

    OperationType(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static OperationType findByOperator(String operator) {
        return Arrays.stream(OperationType.values())
                .filter(v -> operator.equals(v.sign))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", operator)));
    }
}
