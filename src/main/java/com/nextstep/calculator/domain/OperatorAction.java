package com.nextstep.calculator.domain;

@FunctionalInterface
public interface OperatorAction {
    Number act(Number fist, Number second);
}
