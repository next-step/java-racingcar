package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

  @ParameterizedTest
  @CsvSource(value = {"1 + 2,3","2 + 4,6","1 + 3,4","5 + 6,11"})
  void plus(String input, int expected) {
    int result = StringCalculator.calculate(input);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"3 - 2,1","5 - 1,4","10 - 2,8"})
  void minus(String input, int expected) {
    int result = StringCalculator.calculate(input);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"3 * 1,3","2 * 3,6","1 * 2,2"})
  void multiply(String input, int expected) {
    int result = StringCalculator.calculate(input);
    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"3 / 1,3","8 / 2,4","10 / 5,2"})
  void divide(String input, int expected) {
    int result = StringCalculator.calculate(input);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  void calculate() {
    String data = "3 * 2 + 2 / 4 + 3";
    int result = StringCalculator.calculate(data);
    assertThat(result).isEqualTo(5);
  }

  @Test
  @DisplayName("0으로 나눌 경우 IllegalArgumentException 발생")
  void divideWithIllegalArgumentException() {
    String input = "3 / 0";
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> StringCalculator.calculate(input));
  }

  @Test
  @DisplayName("사칙 연산 기호가 아닌 경우 IllegalArgumentException 발생")
  void validOperatorWithIllegalArgumentException() {
    String input = "3 & 2";
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> StringCalculator.calculate(input));
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "  "})
  @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 발생")
  void validNullOrEmptyWithIllegalArgumentException(String input) {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> StringCalculator.calculate(input));
  }

}
