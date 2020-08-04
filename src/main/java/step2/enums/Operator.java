package step2.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.stream.Collectors;

import static step2.constants.ExceptionMessages.CAN_NOT_DIVIDE_ZERO;
import static step2.constants.ExceptionMessages.IS_NOT_OPERATOR;

public enum Operator {

    PLUS_OPERATOR("+", (one, theOther) -> one + theOther),
    SUBTRACT_OPERATOR("-", (one, theOther) -> one - theOther),
    MULTIPLY_OPERATOR("*", (one, theOther) -> one * theOther),
    DIVIDE_OPERATOR("/", (one, theOther) -> {
                                                    if(theOther == 0) {
                                                        throw new IllegalArgumentException(CAN_NOT_DIVIDE_ZERO);
                                                    }
                                                    return one / theOther;
                                                });

    private String sign;

    private ToIntBiFunction<Integer, Integer> computeFunction;

    private static final Map<String, Operator> valuesMap = Collections.unmodifiableMap(Arrays.stream(Operator.values())
                                                                                        .collect(Collectors.toMap(operator -> operator.sign,Function.identity())));

    Operator(String sign, ToIntBiFunction<Integer, Integer> computeFunction) {
        this.sign = sign;
        this.computeFunction = computeFunction;
    }

    public static Operator get(String sign) {
        return getOperator(sign)
                .orElseThrow(()->new IllegalArgumentException(IS_NOT_OPERATOR));
    }

    private static Optional<Operator> getOperator(String sign) {
        return Optional.ofNullable(valuesMap.get(sign));
    }

    public int compute(Integer one, Integer thOther) {
        return this.computeFunction.applyAsInt(one, thOther);
    }
}
