package step2.enums;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

import static step2.enums.ExceptionMessages.CAN_NOT_DIVIDE_ZERO;
import static step2.enums.ExceptionMessages.IS_NOT_OPERATOR;

public enum Operator {

    PLUS_OPERATOR("+", (one, theOther) -> one + theOther),
    SUBTRACT_OPERATOR("-", (one, theOther) -> one - theOther),
    MULTIPLY_OPERATOR("*", (one, theOther) -> one * theOther),
    DIVIDE_OPERATOR("/", (one, theOther) -> {
                                                    if(theOther == 0) {
                                                        throw new IllegalArgumentException(CAN_NOT_DIVIDE_ZERO.toString());
                                                    }
                                                    return one / theOther;
                                                });

    private String sign;

    private BiFunction<Integer, Integer, Integer> computeFunction;

    Operator(String sign, BiFunction<Integer, Integer, Integer> computeFunction) {
        this.sign = sign;
        this.computeFunction = computeFunction;
    }

    public static Operator get(String sign) {
        return getOperator(sign)
                .orElseThrow(()->new IllegalArgumentException(IS_NOT_OPERATOR.toString()));
    }

    private static Optional<Operator> getOperator(String sign) {
        return Arrays.stream(Operator.values()).filter(operator -> operator.sign.equals(sign)).findFirst();
    }

    public Integer compute(Integer one, Integer thOther) {
        return this.computeFunction.apply(one, thOther);
    }
}
