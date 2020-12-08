package calculator;

import java.util.function.BiFunction;

public enum Operator {

    ADDITION("+", (x, y) -> x + y)              // 덧셈
    , SUBTRACTION("-", (x, y) -> x - y)         // 뺄셈
    , MULTIPLICATION("*", (x, y) -> x * y)      // 곱셈
    , DIVISION("/", (x, y) -> x / y)            // 나눗셈
    ;

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String s, BiFunction<Integer, Integer, Integer> function) {
        this.operator = s;
        this.function = function;
    }

    /**
     * 해당 값에 맞는 사칙연산을 합니다.
     * @param x
     * @param y
     * @return
     */
    public int calculate(int x, int y) {
        return this.function.apply(x, y);
    }

    public boolean equals(String operator) {
        return this.operator.equals(operator);
    }

    /**
     * 연산기호를 받아 알맞은 사칙연산을 반환합니다.
     * @param operator
     * @return Operator
     */
    public static Operator valueOfOperator(String operator) {
        if(ADDITION.equals(operator)) {
            return ADDITION;
        }
        if(SUBTRACTION.equals(operator)) {
            return SUBTRACTION;
        }
        if(MULTIPLICATION.equals(operator)) {
            return MULTIPLICATION;
        }
        if(DIVISION.equals(operator)) {
            return DIVISION;
        }
        throw new IllegalArgumentException("입력값의 기호가 사칙연산 기호가 아닙니다.");
    }


}
