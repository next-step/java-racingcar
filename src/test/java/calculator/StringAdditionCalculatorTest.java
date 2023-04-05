package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAdditionCalculatorTest {

  @ParameterizedTest
  @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
  @DisplayName("입력받은 문자열의 각 숫자의 합을 반환한다")
  void sumTest(String input, int expected) {
    // given
    StringAdditionCalculator calculator = new StringAdditionCalculator(input);

    // when & then
    Assertions.assertThat(calculator.sum()).isEqualTo(expected);
  }

  @Test
  @DisplayName("빈 문자열을 입력받은 경우 0을 반환한다")
  void sumEmptyTest() {
    // given
    StringAdditionCalculator calculator = new StringAdditionCalculator("");

    // when & then
    Assertions.assertThat(calculator.sum()).isEqualTo(0);
  }

  @ParameterizedTest
  @CsvSource(value = {"//;\n1;2;3|6", "//;\n1;2,3:4|10"}, delimiter = '|')
  @DisplayName("커스텀 구분자를 지정한 문자열의 각 숫자의 합을 반환한다")
  void sumCustomDelimiterTest(String input, int expected) {
    // given
    StringAdditionCalculator calculator = new StringAdditionCalculator(input);

    // when & then
    Assertions.assertThat(calculator.sum()).isEqualTo(expected);
  }

  @ParameterizedTest
  @ValueSource(strings = {"a;2;3", "-1;2;3"})
  @DisplayName("숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외를 발생시킨다")
  void sumExceptionTest(String input) {
    // given
    StringAdditionCalculator calculator = new StringAdditionCalculator(input);

    // when & then
    Assertions.assertThatThrownBy(() -> calculator.sum())
        .isInstanceOf(RuntimeException.class);
  }
}
