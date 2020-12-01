package com.nextstep.calculator.domain;

@FunctionalInterface
public interface Calculate {
    Number calculate(Number fist, Number second);
}
