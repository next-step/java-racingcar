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
  @CsvSource(value = {"2 + 3 + 4:9", "4 + 7 + 3 + 10:24"}, delimiter = ':')
  @DisplayName("여러 유효한 수들의 덧셈을 통해 값을 반환한다.")
  void sum(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"20 - 3 - 5 :12", "32 - 10 - 5 - 4:13"}, delimiter = ':')
  @DisplayName("여러 유효한 수들의 뺄셈 통해 값을 반환한다.")
  void sub(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"4 * 3 * 5:60", "10 * 10 * 3:300"}, delimiter = ':')
  @DisplayName("여러 유효한 수들의 곱셈을 통해 값을 반환한다.")
  void multiply(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"100 / 10 / 2:5", "60 / 4 / 3:5", "2 / 5:0"}, delimiter = ':')
  @DisplayName("여러 유효한 수들의 나눗셈을 통해 값을 반환한다.")
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
  @CsvSource(value = {"2 + 3 * 4 / 2:10", "5 - 3 / 2 * 3:3", "5 * 4 - 10 / 2 * 4:20"}, delimiter = ':')
  @DisplayName("계산 기능 통합 테스트")
  void unionCalculateTest(String input, int result) {
    assertThat(calculator.calculate(input)).isEqualTo(result);
  }
}
