package com.cspark.nextstep.step21;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculationTest {

  @DisplayName("문자열 더하기")
  @Test
  void add() {
    assertThat(StringCalculation.calculate("1 + 2"))
        .isEqualTo(3);
  }

  @DisplayName("문자열 빼기")
  @Test
  void subtract() {
    assertThat(StringCalculation.calculate("3 - 2"))
        .isEqualTo(1);
  }

  @DisplayName("문자열 곱하기")
  @Test
  void multiply() {
    assertThat(StringCalculation.calculate("2 * 2"))
        .isEqualTo(4);
  }

  @DisplayName("문자열 나누기")
  @Test
  void divide() {
    assertThat(StringCalculation.calculate("4 / 2"))
        .isEqualTo(2);
  }

  @DisplayName("null, 빈 문자열, 공백 문자열은 에러 발생")
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {" "})
  void giveBlankOrNull_whenCalculate_thenThrowsIllegalArgumentException(String value) {
    assertThatThrownBy(() ->
        StringCalculation.calculate(value))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("잘못된 입력값입니다.");
  }

  @DisplayName("사직연사 기호가 아닐 경우 에러 발생")
  @Test
  void giveWrongOperator_whenCalculate_thenThrowsIllegalArgumentException() {
    assertThatThrownBy(() ->
        StringCalculation.calculate("1 % 2"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("지원하지 않는 연산입니다.");
  }
}
