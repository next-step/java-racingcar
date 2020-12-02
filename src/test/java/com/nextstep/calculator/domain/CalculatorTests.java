package com.nextstep.calculator.domain;

import com.nextstep.calculator.domain.exceptions.InvalidCalculatorFormulaException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
    @ParameterizedTest
    @MethodSource("createFailTestResource")
    void createFailTest(List<Operator> operators, List<Number> numbers) {
        assertThatThrownBy(() -> new Calculator(operators, numbers))
                .isInstanceOf(InvalidCalculatorFormulaException.class);
    }
    public static Stream<Arguments> createFailTestResource() {
        return Stream.of(
                // Number 컬렉션의 수 != Operator 컬렉션의 수 + 1
                Arguments.of(
                        Collections.singletonList(Operator.PLUS),
                        Arrays.asList(Number.of("1"), Number.of("2"), Number.of("3"))
                ),

                Arguments.of(
                        Arrays.asList(Operator.PLUS, Operator.PLUS),
                        Arrays.asList(Number.of("1"), Number.of("2"))
                ),
                Arguments.of(
                        Arrays.asList(Operator.PLUS, Operator.PLUS),
                        Collections.singletonList(Number.of("1"))
                ),

                // Number 컬렉션, Operator 컬렉션 중 하나라도 빈 경우
                Arguments.of(
                        Collections.singletonList(Operator.PLUS),
                        new ArrayList<>()
                ),
                Arguments.of(
                        new ArrayList<>(),
                        Collections.singletonList(Number.of("1"))
                )
        );
    }
}