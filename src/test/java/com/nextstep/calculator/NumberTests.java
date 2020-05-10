package com.nextstep.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTests {
    private Number three;
    private Number five;

    @BeforeEach
    public void setup() {
        three = Number.stringToNumber("3");
        five = Number.stringToNumber("5");
    }

    @DisplayName("문자열 형태의 int 타입 값을 속성으로 갖는 Number 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = {"3", "0", "-3"})
    void createNumberFromString(String inputString) {
        Number number = Number.stringToNumber(inputString);

        assertThat(number.value()).isEqualTo(Integer.parseInt(inputString));
    }

    @DisplayName("숫자로 변환 불가능한 인자로 객체 생성 시도 시 에러 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"hello", "can't parse", "   "})
    void createNumberFromInvalidStrings(String invalidInput) {
        assertThatThrownBy(() -> Number.stringToNumber(invalidInput)).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("Number끼리 덧셈 연산 실행")
    @Test
    void plusTest() {
        assertThat(three.plus(five)).isEqualTo(Number.stringToNumber("8"));
    }

    @DisplayName("Number끼리 뺄셈 연산 실행")
    @Test
    void minusTest() {
        assertThat(three.minus(five)).isEqualTo(Number.stringToNumber("-2"));
    }

    @DisplayName("Number끼리 곱셈 연산 실행")
    @Test
    void multiplyTest() {
        assertThat(three.multiply(five)).isEqualTo(Number.stringToNumber("15"));
    }

    @DisplayName("Number끼리 나눗셈 연산 실행")
    @Test
    void divideTest() {
        assertThat(three.divide(five)).isEqualTo(Number.stringToNumber("0"));
    }

    @DisplayName("0으로 나누는 경우 에러 발생")
    @Test
    void divideZeroTest() {
        assertThatThrownBy(() -> three.divide(Number.stringToNumber("0"))).isInstanceOf(ArithmeticException.class);
    }
}
