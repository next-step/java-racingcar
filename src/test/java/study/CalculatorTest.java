package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

  @ParameterizedTest
  @CsvSource(value = {"1 + 1:2", "0 + 1:1", "43 + 57:100"}, delimiter = ':')
  @DisplayName("더하기")
  public void addTest(String input, Integer expected) {
    Integer result = new Calculator(input).evalAll().getResult();

    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"4 - 1:3", "4 - 7:-3", "0 - 1:-1"}, delimiter = ':')
  @DisplayName("빼기")
  public void subtractTest(String input, Integer expected) {
    Integer result = new Calculator(input).evalAll().getResult();

    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"1 * 1:1", "32411334 * 0:0", "256 * 256:65536"}, delimiter = ':')
  @DisplayName("곱하기")
  public void multiplyTest(String input, Integer expected) {
    Integer result = new Calculator(input).evalAll().getResult();

    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"1 / 1:1", "256 / 2:128", "121 / 11:11"}, delimiter = ':')
  @DisplayName("나누기")
  public void divideTest(String input, Integer expected) {
    Integer result = new Calculator(input).evalAll().getResult();

    assertThat(result).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2 - 5:5", "6 / 3 + 1 * 3 - 5:4", "10 * 10 - 20 / 8 + 90:100"}, delimiter = ':')
  @DisplayName("검증 및 혼합 연산 테스트")
  public void validateAndMixedOperationTest(String input, Integer expected) {
    String validInput = new InputValidator(input)
        .checkHasBlank()
        .checkHasWrongOperator()
        .checkHasAllOperator()
        .getValue();
    Integer result = new Calculator(validInput).evalAll().getResult();

    assertThat(result).isEqualTo(expected);
  }
}
