package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public enum OperatorType {

    PLUS("+", Long::sum),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b);

    private String code;
    private BiFunction<Long, Long, Long> expression;

    OperatorType(String code, BiFunction<Long, Long, Long> expression) {
        this.code = code;
        this.expression = expression;
    }

    public String getCode() {
        return code;
    }

    public BiFunction<Long, Long, Long> getExpression() {
        return expression;
    }

    public static List<String> getOperatorCodes() {
        return Arrays.stream(OperatorType.values())
                .map(OperatorType::getCode)
                .collect(Collectors.toList());
    }

    public static OperatorType findByCode(String code) {
        return Arrays.stream(OperatorType.values())
                .filter(o -> o.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));

    }

    public static boolean isOperatorType(String type) {
        return getOperatorCodes().contains(type);
    }
    public static boolean isNotOperatorType(String type) {
        return !isOperatorType(type);
    }
}
