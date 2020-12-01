package com.nextstep.calculator.domain;

@FunctionalInterface
public interface Calculate {
    int calculate(Number fist, Number second);
}
