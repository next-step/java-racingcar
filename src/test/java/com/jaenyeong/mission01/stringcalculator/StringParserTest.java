package com.jaenyeong.mission01.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("주어진 문자열을 수식으로 변환하기 위한 StringParser 클래스 테스트")
class StringParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "3 * 5 + 5 / 4", "1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9", "-1 * -3 * 7 + 5"})
    @DisplayName("파라미터가 올바른 문자열인 경우 Parser 객체 생성 테스트")
    void createParserInstanceWhenGivenValidExpression(final String exp) {
        final StringParser sp = new StringParser(exp);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 3", "* / /", "1 * 2 3", "111", "", "1 + 2 + +", "3 3 3 / 4", "1   +   2"})
    @DisplayName("연산자, 피연산자의 위치 또는 개수가 올바르지 않은 경우 Parser 객체 생성 테스트")
    void createParserInstanceWhenGivenInvalidExpression(final String exp) {
        assertThatThrownBy(() -> {
            final StringParser sp = new StringParser(exp);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(exp + " is not valid expression");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ^ 2", "1 & 3 & 6", "1 ! 3 _ 5"})
    @DisplayName("연산자가 올바르지 않은 경우 Parser 객체 생성 테스트")
    void createParserInstanceWhenGivenNotOperationExpression(final String exp) {
        assertThatThrownBy(() -> {
            final StringParser sp = new StringParser(exp);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(exp + " is not valid expression");
    }
}
