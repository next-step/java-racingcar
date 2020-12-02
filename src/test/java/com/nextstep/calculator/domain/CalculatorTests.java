package com.nextstep.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTests {
    @DisplayName("Number 컬렉션, Operator 컬렉션을 인자로 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<Operator> operators = Arrays.asList(Operator.PLUS, Operator.MINUS);
        List<Number> numbers = Arrays.asList(Number.of("1"), Number.of("2"), Number.of("3"));

        assertThat(new Calculator(operators, numbers)).isNotNull();
    }
}