package study.step2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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

  @Test
  @DisplayName("숫자가 아닐 경우 exception")
  void parseInt_fail() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> this.stringCalculator.parseInt("string"));
  }

  @Test
  @DisplayName("null 들어올 경우 IllegalArgumentException")
  void null_fail() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> this.stringCalculator.calculate(null));
  }

  @Test
  @DisplayName("blank 들어올 경우 IllegalArgumentException")
  void blank_fail() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> this.stringCalculator.calculate(" "));
  }

  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2,10", "2 + 3 - 1 * 2 / 4,2"})
  @DisplayName("expression 식을 계산한 결과")
  void calculate(String expression, int expected) {
    int result = this.stringCalculator.calculate(expression);
    assertEquals(expected, result);
  }

}
