package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @DisplayName("음수와 양수에 대한 덧셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "2 + 3 + 4:"+(2 + 3 + 4),
    "-2 + -3 + -4:"+(-2 + -3 + -4),
  }, delimiter = ':')
  void 덧셈_테스트 (String expression, int expected) {
     calculator.getExpression(expression);
     assertThat(expected).isEqualTo(calculator.getResult());
  }

  @DisplayName("음수와 양수에 대한 뺄셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "2 - 3 - 4:" + (2 - 3 - 4),
    "2 - -3 - -4:" + (2 - -3 - -4),
  }, delimiter = ':')
  void 뺄셈_테스 (String expression, int expected) {
     calculator.getExpression(expression);
     assertThat(expected).isEqualTo(calculator.getResult());
  }

  @DisplayName("음수와 양수에 대한 곱셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "2 * 3 * 4:" + (2 * 3 * 4),
    "-2 * -3 * -4:" + (-2 * -3 * -4),
  }, delimiter = ':')
  void 곱셈_테스트 (String expression, int expected) {
    calculator.getExpression(expression);
    assertThat(expected).isEqualTo(calculator.getResult());
  }

  @DisplayName("음수, 양수, 소수에 대한 나눗셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "20 / 10:" + (20 / 10),
    "-20 / 15:" + (-20.0 / 15),
    "-20 / -12:" + (-20.0 / -12),
  }, delimiter = ':')
  void 나눗셈_테스트 (String expression, int expected) {
    calculator.getExpression(expression);
    assertThat(expected).isEqualTo(calculator.getResult());
  }
}
