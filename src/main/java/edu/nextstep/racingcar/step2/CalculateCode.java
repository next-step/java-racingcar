package edu.nextstep.racingcar.step2;

import edu.nextstep.racingcar.common.BusinessException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum CalculateCode {

    ADD("+", (x, y) ->  new CalculatorUtils().addition(x, y)),
    SUB("-", (x, y) ->  new CalculatorUtils().subtraction(x, y)),
    MULTI("*", (x, y) ->  new CalculatorUtils().multiplication(x, y)),
    DIV("/", (x, y) ->  new CalculatorUtils().division(x, y));

    private final String value;
    private final BiFunction<Long, Long, Long> calculator;

    CalculateCode(String value, BiFunction<Long, Long, Long> calculator) {
        this.value = value;
        this.calculator = calculator;
    }

    public BiFunction<Long, Long, Long> getCalculator() {
        return calculator;
    }

    public static CalculateCode findByValue(String value) {
        return Arrays.stream(values())
                .filter(codeValue -> codeValue.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new BusinessException(CalculatorError.INVALID_VALUE));
    }
}
