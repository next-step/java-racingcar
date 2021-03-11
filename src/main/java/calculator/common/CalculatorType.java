package calculator.common;

import java.util.function.BiFunction;

public enum CalculatorType {
    ADD("+", (prevNum, postNum) -> prevNum + postNum),
    SUBTRACTION("-", (prevNum, postNum) -> prevNum - postNum),
    MULTIPLICATION("*", (prevNum, postNum) -> prevNum * postNum),
    DIVISION("/", (prevNum, postNum) -> prevNum / postNum);

    private String mark;
    private BiFunction<Integer, Integer, Integer> expression;

    CalculatorType(String mark, BiFunction<Integer, Integer, Integer> expression) {
        this.mark = mark;
        this.expression = expression;
    }

    public int calculate(int prevNum, int postNum) {
        return expression.apply(prevNum, postNum);
    }

    public String getMark() {
        return this.mark;
    }
}
