package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;


/**
 * 사칙연산자 Enum 클래스
 */
public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        return a / b;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> expression;
    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
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

    /**
     * 표현식 적용하기
     * @param a 입력값
     * @param b 입력값
     * @return 연산 결과
     */
    public int apply(int a, int b) {
        return expression.apply(a, b);
    }

}
