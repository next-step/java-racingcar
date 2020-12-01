package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  public void setup() {
    calculator = new Calculator();
  }

  @DisplayName("단숫 덧셈한 결과를 출력한다.")
  @ParameterizedTest
  @CsvSource(value = {"1 + 2 = 3", "100 + 100 = 200"}, delimiter = '=')
  void plus(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @DisplayName("단순 뺄셈한 결과를 출력한다.")
  @ParameterizedTest
  @CsvSource(value = {"1 - 2 = -1", "100 - 100 = 0"}, delimiter = '=')
  void minus(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @DisplayName("단순 곱셈 결과를 출력한다.")
  @CsvSource(value = {"1 * 2 = 2", "100 * 100 = 10000", "3 * -10 = -30"}, delimiter = '=')
  @ParameterizedTest
  void multiply(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @DisplayName("단순 나눗셈 결과를 출력한다.")
  @ParameterizedTest
  @CsvSource(value = {"1 / 2 = 0", "100 / 100 = 1", "100 / 1 = 100"}, delimiter = '=')
  void divide(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @DisplayName("복합적 계산의 결과를 출력한다.")
  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2 = 10"}, delimiter = '=')
  void multipleInput(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @DisplayName("입력 값이 null인 경우 Exception")
  @Test
  void nullInputCheck() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.calculate(null);
    });
  }

  @DisplayName("입력 값이 빈 공백 문자일 경우 Exception")
  @Test
  void emptyInputCheck() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.calculate("");
    });
  }

  @DisplayName("사칙연산 기호가 아닌 경우 Exception")
  @Test
  void operatorCheck() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.calculate("1 $ 2");
    });
  }

  @DisplayName("나눗셈에서 0으로 나눈 경우는 Exception")
  @Test
  void multiply() {
    assertThatIllegalArgumentException().isThrownBy(() -> {
      calculator.calculate("100 / 0");
    });
  }
}
