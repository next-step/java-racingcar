package stringcalculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

//Java의 Enum을 통해 '연산자' 코드 관리 및 IntBinaryOperator 활용
//******** ENUM 학습 필요 *************//
public enum StringCalOperator implements IntBinaryOperator {
    ADD("+", (lVal, rVal) -> (lVal + rVal)),
    SUB("-", (lVal, rVal) -> (lVal - rVal)),
    MUL("*", (lVal, rVal) -> (lVal * rVal)),
    DIV("/", (lVal, rVal) -> {
        if (rVal == 0) {
            throw new IllegalArgumentException();
        }
        return (lVal / rVal);
    });

    private final String operator;
    private final IntBinaryOperator binaryOperator;

    StringCalOperator(String operator, IntBinaryOperator binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public String getOperator(){
        return operator;
    }

    @Override
    public int applyAsInt(final int left,final int right) {
        return binaryOperator.applyAsInt(left, right);
    }

    //******** Stream API 학습 필요 *************//
    //***of? another function FindOperation?//
    public static StringCalOperator findOperation(String operator) {
        return Arrays.stream(values())
                .filter(s -> s.operator.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

