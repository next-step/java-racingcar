package calculator.enums;

import calculator.exceptions.InvalidOperatorException;
import calculator.exceptions.InvalidValueException;
import calculator.operators.Operator;

import java.util.Arrays;

public enum OperatorEnum {

    ADD("+", (value1, value2) -> value1 + value2),
    SUBTRACT("-", (value1, value2) -> value1 - value2),
    DIVIDE("/", (value1, value2) -> {
        if (value2 == 0) {
            throw new InvalidValueException("0으로 나누는 것은 불가능합니다!");
        }
        return value1 / value2;
    }),
    MULTIPLY("*", (value1, value2) -> value1 * value2);

    private final String strOperator;
    private final Operator objOperator;

    OperatorEnum(String strOperator, Operator objOperator) {
        this.strOperator = strOperator;
        this.objOperator = objOperator;
    }

    public static Operator getOperator(String strOperator) {
        return Arrays.stream(OperatorEnum.values())
                .filter(operatorEnum -> operatorEnum.strOperator.equals(strOperator))
                .findFirst()
                .map(foundOperatorEnum -> foundOperatorEnum.objOperator)
                .orElseThrow(InvalidOperatorException::new);
    }

}
