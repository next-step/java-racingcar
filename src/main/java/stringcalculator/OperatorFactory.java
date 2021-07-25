package stringcalculator;

public class OperatorFactory {
    static private final Operator[] operators = {
        PlusOperator.getInstance(), MinusOperator.getInstance(), MultiplyOperator.getInstance(), DivideOperator.getInstance()
    };

    public static Operator create(String sign) {
        for (Operator operator : operators) {
            if (operator.match(sign)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다!");
    }
}
