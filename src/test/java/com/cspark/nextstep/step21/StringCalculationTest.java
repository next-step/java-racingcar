package com.cspark.nextstep.step21;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
