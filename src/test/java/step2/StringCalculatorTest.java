package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @DisplayName("음수와 양수에 대한 덧셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "2 + 3 + 4 = "+(2 + 3 + 4),
    "-2 + -3 + -4 = "+(-2 + -3 + -4),
  }, delimiter = '=')
  void 덧셈_테스트 (String expression, int expected) {
     calculator.expressionScan(expression).calculate();
     assertThat(expected).isEqualTo(calculator.getResult());
  }

  @DisplayName("음수와 양수에 대한 뺄셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "2 - 3 - 4 = " + (2 - 3 - 4),
    "2 - -3 - -4 = " + (2 - -3 - -4),
  }, delimiter = '=')
  void 뺄셈_테스트 (String expression, int expected) {
     calculator.expressionScan(expression).calculate();
     assertThat(expected).isEqualTo(calculator.getResult());
  }

  @DisplayName("음수와 양수에 대한 곱셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "2 * 3 * 4 = " + (2 * 3 * 4),
    "-2 * -3 * -4 = " + (-2 * -3 * -4),
  }, delimiter = '=')
  void 곱셈_테스트 (String expression, int expected) {
    calculator.expressionScan(expression).calculate();
    assertThat(expected).isEqualTo(calculator.getResult());
  }

  @DisplayName("음수 양수에 대한 나눗셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "20 / 10 = " + (20 / 10),
    "-20 / 15 = " + (-20 / 15),
    "-20 / -12 = " + (-20 / -12),
  }, delimiter = '=')
  void 나눗셈_테스트 (String expression, int expected) {
    calculator.expressionScan(expression).calculate();
    assertThat(expected).isEqualTo(calculator.getResult());
  }

  @DisplayName("다양한 사칙연산 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "2 + 3 * 4 / 5 = " + (((2 + 3) * 4) / 5),
    "2 / 3 * 4 + 5 = " + (((2 / 3) * 4) + 5),
    "-2 + 3 * -4 / 5 = " + (((-2 + 3) * -4) / 5),
    "-2 / 3 * -4 + 5 = " + (((-2 / 3) * -4) + 5),
    "200 + 300 * 40 / 5 = " + (((200 + 300) * 40) / 5),
    "1 = " + 1,
  }, delimiter = '=')
  void 사칙연산_테스트 (String expression, int expected) {
    calculator.expressionScan(expression).calculate();
    assertThat(expected).isEqualTo(calculator.getResult());
  }

  @DisplayName("입력 값이 NULL 혹은 공백일 때의 테스트")
  @ParameterizedTest
  @ValueSource(strings = { "", "null", "    " })
  void NULL_혹은_공백_테스트 (String expression) {
    assertThatIllegalArgumentException()
      .isThrownBy(() -> calculator.expressionScan(expression.equals("null") ? null : expression));
  }

  @DisplayName("사칙연산을 포함한 기호가 아닐 경우")
  @ParameterizedTest
  @ValueSource(strings = {
    "1 ! 2",
    "1 + 2 # 3",
    "2 ^ 3",
    "2 & 3",
    "2 | 3",
    "2 % 3",
    "2 $ 3",
  })
  void 유효하지_않은_연산_테스트 (String expression) {
    assertThatIllegalArgumentException()
      .isThrownBy(() -> calculator.expressionScan(expression).calculate());
  }
}
