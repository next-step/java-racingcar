package calculator.enums;

import calculator.operators.*;

import java.util.Arrays;

public enum OperatorEnum {

    ADD("+", new AddOperator()),
    SUBTRACT("-", new SubtractOperator()),
    DIVIDE("/", new DivideOperator()),
    MULTIPLY("*", new MultiplyOperator()),
    EMPTY("", null);

    private final String strOperator;
    private final Operator objOperator;

    OperatorEnum(String strOperator, Operator objOperator) {
        this.strOperator = strOperator;
        this.objOperator = objOperator;
    }

    public static Operator getOperator(String strOperator) {
        return Arrays.stream(OperatorEnum.values())
                .filter(operatorEnum -> operatorEnum.strOperator.equals(strOperator))
                .findAny()
                .map(foundOperatorEnum -> foundOperatorEnum.objOperator)
                .orElse(EMPTY.objOperator);
    }

}
