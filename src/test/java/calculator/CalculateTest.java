package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculateTest {

  private Calculator calculator;

  @BeforeEach
  void setup() {
    calculator = new Calculator();
  }

  @ParameterizedTest
  @CsvSource(value = {"2 + 3:5", "4 + 7:11"}, delimiter = ':')
  @DisplayName("두수의 합을 구한다.")
  void sum(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"10 - 3:7", "32 - 20:12"}, delimiter = ':')
  @DisplayName("두수의 뺄셈을 구한다.")
  void sub(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"4 * 3:12", "20 * 3:60"}, delimiter = ':')
  @DisplayName("두수의 곱을 구한다.")
  void multiply(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"10 / 2:5", "4 * 3:12", "2 / 5:0"}, delimiter = ':')
  @DisplayName("두수의 나눗셈을 구한다.")
  void divide(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @ValueSource(strings = {"10 / 0", "0 / 0"})
  @DisplayName("분모가 0일때 IllegalArgumentException을 던진다.")
  void divideWithZero(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
  }

  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2:10", "5 - 3 / 2 * 3:3"}, delimiter = ':')
  @DisplayName("계산 기능 통합 테스트")
  void testCalculate(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }
}
