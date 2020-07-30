package com.cspark.nextstep.step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

  @DisplayName("더하기")
  @ParameterizedTest
  @CsvSource(value = {"1=1", "1 + 1=2", "1 + 1 + 1=3"}, delimiter = '=')
  void add(String sentenceAsString, int expected) {
    assertThat(StringCalculator.calculate(sentenceAsString))
        .isEqualTo(expected);
  }

  @DisplayName("빼기")
  @ParameterizedTest
  @CsvSource(value = {"1=1", "2 - 1=1", "3 - 2 - 1=0"}, delimiter = '=')
  void subtract(String sentenceAsString, int expected) {
    assertThat(StringCalculator.calculate(sentenceAsString))
        .isEqualTo(expected);
  }

  @DisplayName("곱하기")
  @ParameterizedTest
  @CsvSource(value = {"1=1", "1 * 1=1", "1 * 1 * 1=1"}, delimiter = '=')
  void multiply(String sentenceAsString, int expected) {
    assertThat(StringCalculator.calculate(sentenceAsString))
        .isEqualTo(expected);
  }

  @DisplayName("나누기")
  @ParameterizedTest
  @CsvSource(value = {"1=1", "1 / 1=1", "1 / 1 / 1=1"}, delimiter = '=')
  void divide(String sentenceAsString, int expected) {
    assertThat(StringCalculator.calculate(sentenceAsString))
        .isEqualTo(expected);
  }




}
