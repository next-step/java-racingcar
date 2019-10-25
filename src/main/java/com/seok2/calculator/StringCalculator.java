package com.seok2.calculator;

import java.util.Map;
import java.util.function.BiFunction;

public class StringCalculator {

    public void isEmpty(String expression) {
        if(expression == null || expression.trim().length() == 0)
            throw new IllegalArgumentException();
    }


}
