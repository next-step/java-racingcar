package com.cspark.nextstep.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.cspark.nextstep.step2.calculation.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  @DisplayName("잘못된 입력값")
  @ParameterizedTest
  @NullAndEmptySource
  @ValueSource(strings = {" ", "%"})
  void givenWrong_whenCalculate_thenException(String sentenceAsString) {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .as("규칙에 어긋나는 입력 값일 경우 IllegalArgumentException 발생")
        .isThrownBy(() ->
            StringCalculator.calculate(sentenceAsString));
  }

  @DisplayName("기능 분리 테스트: 덧셈")
  @Test
  void add() {
    Calculator calculator = (x, y) -> x + y;
    assertThat(calculator.calculate(1, 1))
        .isEqualTo(2);
  }

  @DisplayName("기능 분리 테스트: 뺄셈")
  @Test
  void subtraction() {
    Calculator calculator= (x, y) -> x - y;
    assertThat(calculator.calculate(1, 1))
        .isEqualTo(0);
  }

  @DisplayName("기능 분리 테스트: 곱셈")
  @Test
  void multiply() {
    Calculator calculator =  (x, y) -> x * y;
    assertThat(calculator.calculate(2, 2))
        .isEqualTo(4);
  }

  @DisplayName("기능 분리 테스트: 나누셈")
  @Test
  void divide() {
    Calculator calculator = (x, y) -> x / y;
    assertThat(calculator.calculate(2, 2))
        .isEqualTo(1);
  }

  @DisplayName("단일 연산")
  @ParameterizedTest
  @CsvSource(value = {"1=1",
      "1 + 1=2", "1 + 1 + 1=3",
      "2 - 1=1", "3 - 2 - 1=0",
      "1 * 1=1", "1 * 1 * 1=1",
      "1 / 1=1", "1 / 1 / 1=1"
  }, delimiter = '=')
  void givenOneExpress_whenCalculate_thenExpected(String sentenceAsString, int expected) {
    assertThat(StringCalculator.calculate(sentenceAsString))
        .isEqualTo(expected);
  }

  @DisplayName("사칙 연산")
  @ParameterizedTest
  @CsvSource(value = {
      "2 - 1 + 3 * 2 / 2=4",
      "2 + 3 * 4 / 2=10",
      "1 + 3 / 2 * 5=10",
      "3 - 2 * 4 / 2=2",
  }, delimiter = '=')
  void givenMultiExpress_whenCalculate_thenExpected(String sentenceAsString, int expected) {
    assertThat(StringCalculator.calculate(sentenceAsString))
        .isEqualTo(expected);
  }

}
