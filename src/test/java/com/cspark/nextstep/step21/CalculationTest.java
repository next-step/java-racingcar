package com.cspark.nextstep.step21;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculationTest {

  @DisplayName("숫자 더하기")
  @Test
  void add() {
    assertThat(Calculation.ADD.calculate(1, 2))
        .isEqualTo(3);
  }

  @DisplayName("숫자 빼기")
  @Test
  void subtract() {
    assertThat(Calculation.SUBTRACT.calculate(3, 2))
        .isEqualTo(1);
  }

  @DisplayName("숫자 곱하기")
  @Test
  void multiply() {
    assertThat(Calculation.MULTIPLY.calculate(2, 2))
        .isEqualTo(4);
  }

  @DisplayName("숫자 나누기")
  @Test
  void divide() {
    assertThat(Calculation.DIVIDE.calculate(4, 2))
        .isEqualTo(2);
  }
}