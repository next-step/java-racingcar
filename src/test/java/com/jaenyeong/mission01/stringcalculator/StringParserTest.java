package com.jaenyeong.mission01.stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("주어진 문자열을 수식으로 변환하기 위한 StringParser 클래스 테스트")
class StringParserTest {

    @ParameterizedTest
    @ValueSource(strings = {"1 + 2", "3 * 5 + 5 / 4", "1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9", "-1 * -3 * 7 + 5"})
    @DisplayName("올바른 수식인 경우")
    void checkWhenGivenValidExpression(final String exp) {
        final List<String> operators = new ArrayList<>();
        final List<Integer> operands = new ArrayList<>();
        parseOperatorsAndOperands(operators, operands, exp);

        final StringParser sp = new StringParser();
        final Expression resultExp = sp.parseExpression(exp);
        final List<String> expOperators = resultExp.getOperators();
        final List<Integer> expOperands = resultExp.getOperands();

        assertEquals(expOperators, operators);
        assertEquals(expOperands, operands);
    }

    private void parseOperatorsAndOperands(final List<String> operators, final List<Integer> operands, final String exp) {
        final String numberRegex = "^[+-]?\\d+$";

        final String[] expElements = exp.split(" ");
        for (String e : expElements) {
            if (e.matches(numberRegex)) {
                operands.add(Integer.valueOf(e));
                continue;
            }

            switch (e) {
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.add(e);
                    break;
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 ^ 2", "1 & 3 & 6", "1 ! 3 _ 5"})
    @DisplayName("올바르지 않은 특수문자가 포함된 수식인 경우")
    void checkWhenGivenInvalidCharacterInExpression(final String exp) {
        assertThatThrownBy(() -> {
            final StringParser sp = new StringParser();
            final Expression resultExp = sp.parseExpression(exp);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(exp + " is not valid expression");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 2 3", "* / /", "1 * 2 3", "111", "", "1 + 2 + +", "3 3 3 / 4", "1   +   2"})
    @DisplayName("연산자, 피연산자의 위치 또는 개수가 올바르지 않은 경우")
    void checkWhenGivenInvalidNumberOfOperatorsAndOperands(final String exp) {
        assertThatThrownBy(() -> {
            final StringParser sp = new StringParser();
            final Expression resultExp = sp.parseExpression(exp);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(exp + " is not valid expression");
    }
}
