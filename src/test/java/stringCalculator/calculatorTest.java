package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class calculatorTest {

  private final Calculator calculator = new Calculator();

  @DisplayName("주어진 숫자가 두개일 때 사칙연산 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "1 + 2:3", "2 + 3:5", "3 + 4:7", "6 + 8:14", "12 + 15:27",
      "7 - 2:5", "1 - 3:-2", "10 - 7:3", "19 - 5:14", "6 - 7:-1",
      "1 * 2:2", "3 * 4:12", "5 * 9:45", "4 * 7:28", "7 * 8:56",
      "10 / 2:5", "22 / 2:11", "6 / 3:2", "15 / 3:5", "20 / 5:4"
  }, delimiter = ':')
  void calculate(String input, String expected) {
    int result = calculator.calculate(input);
    assertThat(result).isEqualTo(Integer.parseInt(expected));
  }

  @DisplayName("주어진 숫자가 여러개일 때 사칙연산 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "1 + 2 + 3 + 4:10" , "2 + 3 * 4 / 2:10"
  }, delimiter = ':')
  void given_many_number_calculate(String input, String expected) {
    int result = calculator.calculate(input);
    assertThat(result).isEqualTo(Integer.parseInt(expected));
  }

  @DisplayName("입력 값이 null")
  @Test
  void given_input_null() {
    assertThatThrownBy(() -> calculator.calculate(null))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("input is null or empty");
  }

  @DisplayName("입력 값이 빈 공백문자")
  @Test
  void given_input_empty() {
    assertThatThrownBy(() -> calculator.calculate(""))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("input is null or empty");
  }

  @DisplayName("사칙연산 기호가 아닌 경우")
  @Test
  void given_not_contains_operation() {
    assertThatThrownBy(() -> calculator.calculate("2 # 4"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("input not contains operation");
  }


}
