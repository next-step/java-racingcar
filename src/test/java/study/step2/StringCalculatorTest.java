package study.step2;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StringCalculatorTest {
  StringCalculator stringCalculator = new StringCalculator();

  @Test
  @DisplayName("String -> int")
  void parseInt() {
    int number = this.stringCalculator.parseInt("9");
    assertEquals(9, number);
  }

  @ParameterizedTest
  @CsvSource(value = {"4,5,9", "2,3,5", "4,2,6"})
  @DisplayName("숫자가 아닐 경우 exception")
  void parseInt_fail() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> this.stringCalculator.parseInt("string"));
  }

  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2,10", "2 + 3 - 1 * 2 / 4,2"})
  @DisplayName("expression 식을 계산한 결과")
  void calculate(String expression, int expected) {
    int result = this.stringCalculator.calculate(expression);
    assertEquals(expected, result);
  }

}
