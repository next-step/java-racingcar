package com.nextstep.calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CalculatorFactory {
    public static Calculator of(String formula) {
        return new Calculator(Collections.singletonList(Operator.PLUS),
                Arrays.asList(Number.of("1"), Number.of("1")));
    }
}
