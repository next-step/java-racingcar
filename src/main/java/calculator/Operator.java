package calculator;

import java.util.Arrays;

/**
 * 사칙연산자 Enum 클래스
 */
public enum Operator {

    PLUS("+", "plus"),
    MINUS("-", "minus"),
    MULTIPLY("*", "multiply"),
    DIVIDE("/", "divide");

    private final String symbol;
    private final String methodName;
    Operator(String symbol, String methodName) {
        this.symbol = symbol;
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    /**
     * 심볼으로 연산자 찾기
     * @param symbol 사칙연산자 심볼
     * @return 사칙연산자 Enum
     */
    public static Operator findBySymbol(String symbol) {
        return Arrays.stream(values())
                .filter(e -> e.symbol.equals(symbol))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

}
