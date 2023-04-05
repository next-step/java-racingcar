package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAdditionCalculatorTest {

  StringAdditionCalculator calculator = StringAdditionCalculator.getInstance();

  @ParameterizedTest
  @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
  @DisplayName("입력받은 문자열의 각 숫자의 합을 반환한다")
  void sumTest(String input, int expected) {
    assertThat(
        calculator.sum(
            new AdditionalString(input)
        ))
        .isEqualTo(expected);
  }

  @Test
  @DisplayName("빈 문자열을 입력받은 경우 0을 반환한다")
  void sumEmptyTest() {
    assertThat(
        calculator.sum(
            new AdditionalString("")
        ))
        .isEqualTo(0);
  }

  @Test
  @DisplayName("커스텀 구분자를 지정한 문자열의 각 숫자의 합을 반환한다")
  void sumCustomDelimiterTest() {
    // when & then
    assertThat(
        calculator.sum(
            new AdditionalString("//;\n1;2,3:4")
        )).isEqualTo(10);
  }

  @ParameterizedTest
  @ValueSource(strings = {"a;2;3", "-1;2;3"})
  @DisplayName("숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외를 발생시킨다")
  void sumExceptionTest(String input) {
    Assertions.assertThatThrownBy(() ->
            calculator.sum(
                new AdditionalString(input))
        )
        .isInstanceOf(RuntimeException.class);
  }
}
