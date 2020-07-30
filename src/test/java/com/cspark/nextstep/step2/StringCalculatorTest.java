package com.cspark.nextstep.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
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
      "2 + 3 * 4 / 2=10",
  }, delimiter = '=')
  void givenMultiExpress_whenCalculate_thenExpected(String sentenceAsString, int expected) {
    assertThat(StringCalculator.calculate(sentenceAsString))
        .isEqualTo(expected);
  }

}
