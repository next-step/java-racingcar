package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

  @DisplayName("null 또는 빈문자열을_전달하면_0을_반환한다")
  @ParameterizedTest
  @NullAndEmptySource
  void nullOrEmptyStringInputReturnsZero(final String input) {
    assertThat(Calculator.calculate(input)).isEqualTo(0);
  }

  @DisplayName("기본_구분자_외에_커스텀_구분자를_추가할_수_있다")
  @ParameterizedTest(name = "{index} => input={0}, expectedResult={1}")
  @CsvSource({
          "'//&\n1&2&3&4', 10",
          "'//@\n1@2@3@4', 10",
          "'//#\n1#2#3#4', 10",
          "'//*\n1*2*3*4', 10"
  })
  void calculateWithCustomDelimiter(final String input, final int expectedResult) {
    assertThat(Calculator.calculate(input)).isEqualTo(expectedResult);
  }

  @DisplayName("숫자_하나를_전달하면_값을_그대로_반환한다")
  @ParameterizedTest(name = "{index} => input={0}, expectedResult={1}")
  @CsvSource({"1,1", "2,2", "10,10"})
  void singleNumberInput(final String input, final int expectedResult) {
    assertThat(Calculator.calculate(input)).isEqualTo(expectedResult);
  }

  @DisplayName("숫자_여러개를_콤마_콜론과_함께_전달하면_여러_숫자를_더한다")
  @ParameterizedTest(name = "{index} => input={0}, expectedResult={1}")
  @CsvSource(value = {"1,2= 3", "1:2= 3", "1,2:3= 6", "1,2:3,4= 10", "1:2:100,3= 106"}, delimiter = '=')
  void multipleNumberWithDefaultDelimiterInput(final String input, final int expectedResult) {
    assertThat(Calculator.calculate(input)).isEqualTo(expectedResult);
  }

  @DisplayName("숫자이외의_값을_전달하면_RuntimeException_반환한다")
  @ParameterizedTest()
  @ValueSource(strings = {"문자", "1:2,3:A", "3:2:!", "1:ABC,@"})
  void inputNotNumberReturnsRuntimeException(final String input) {
    assertThatThrownBy(() -> {
      Calculator.calculate(input);
    }).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("음수를_전달하면_RuntimeException_반환한다")
  @ParameterizedTest()
  @ValueSource(strings = {"-1", "1:-1", "1:2,:-1"})
  void inputNegativeNumberReturnsRuntimeException(final String input) {
    assertThatThrownBy(() -> {
      Calculator.calculate(input);
    }).isInstanceOf(RuntimeException.class);
  }
}