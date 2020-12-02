package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidCalculatorFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTests {
    @DisplayName("Number 컬렉션, Operator 컬렉션을 인자로 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        List<Operator> operators = Arrays.asList(Operator.PLUS, Operator.MINUS);
        List<Number> numbers = Arrays.asList(Number.of("1"), Number.of("2"), Number.of("3"));

        assertThat(new Calculator(operators, numbers)).isNotNull();
    }

    @DisplayName("숫자와 수식의 짝이 맞지 않는 경우 예외가 발생한다.")
    @Test
    void createFailTest() {
        List<Operator> operators = Collections.singletonList(Operator.PLUS);
        List<Number> numbers = Arrays.asList(Number.of("1"), Number.of("2"), Number.of("3"));

        assertThatThrownBy(() -> new Calculator(operators, numbers))
                .isInstanceOf(InvalidCalculatorFormulaException.class);
    }
}