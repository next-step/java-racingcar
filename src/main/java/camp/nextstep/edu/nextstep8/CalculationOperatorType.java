package camp.nextstep.edu.nextstep8;

import java.util.function.BiFunction;

public enum CalculationOperatorType {
    ADD ("+", (val1, val2) -> (val1 + val2)),
    SUB ("-", (val1, val2) -> (val1 - val2)),
    MUL ("*", (val1, val2) -> (val1 * val2)),
    DIV ("/", (val1, val2) -> {
        if (val2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
        return (val1 / val2);
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    CalculationOperatorType(String oprator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = oprator;
        this.expression = expression;
    }

    public int operation(int val1, int val2){
        return expression.apply(val1, val2);
    }

    public String getOperator() {
        return operator;
    }

    public static CalculationOperatorType getOperatorTypeByOperator (String operator) {
        for (CalculationOperatorType type : CalculationOperatorType.values()) {
            if(type.getOperator().equals(operator)) {
                return type;
            }
        }
        throw new IllegalArgumentException();
    }
}
