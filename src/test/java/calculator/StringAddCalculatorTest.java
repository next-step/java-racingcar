package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {
  @ParameterizedTest
  @CsvSource(value={"1,2:3=6", "2,3:4=9", "3,4:5=12", "1=1"}, delimiter = '=')
  @DisplayName("쉼표 또는 콜론을 구분자로 가지는 문자열을 입력하면 구분자를 기준으로 숫자를 더한 값을 반환한다.")
  void testCalculateWithoutCustomSplitter(String input, int expected) {
    int result = StringAddCalculator.calculate(input);
    assertEquals(expected, result);
  }

  static Stream<Arguments> provideCustomSplitterCases() {
    return Stream.of(
            Arguments.of("//@\n1@2@3", 6),
            Arguments.of("//&\n2&3&4", 9),
            Arguments.of("//<\n10<2", 12)
    );
  }

  @ParameterizedTest
  @MethodSource("provideCustomSplitterCases")
  @DisplayName("커스텀 구분자를 가지는 문자열을 입력하면 구분자를 기준으로 숫자를 더한 값을 반환한다.")
  void testCalculateWithCustomSplitter(String input, int expected) {
    int result = StringAddCalculator.calculate(input);
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("빈 문자열 또는 null 값을 입력하면 0을 반환한다.")
  void testCalculateWithEmptyString() {
    String input = "";
    int expected = 0;

    int result = StringAddCalculator.calculate(input);
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("null 값을 입력하면 0을 반환한다.")
  void testCalculateWithNull() {
    String input = null;
    int expected = 0;

    int result = StringAddCalculator.calculate(input);
    assertEquals(expected, result);
  }

  static Stream<Arguments> provideNonNumericCases() {
    return Stream.of(
            Arguments.of("1>2:3"),
            Arguments.of("//@\n1@2<3"),
            Arguments.of("a"),
            Arguments.of("1:2:3:a")
    );
  }

  @ParameterizedTest
  @MethodSource("provideNonNumericCases")
  @DisplayName("숫자가 아닌 값을 포함하는 문자열을 입력하면 IllegalArgumentException을 반환한다.")
  void testCalculateWithCustomSplitter(String input) {
    assertThatThrownBy(() -> {
      StringAddCalculator.calculate(input);
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("음수 또는 숫자가 아닌 값이 포함되어 있습니다.");
  }

  static Stream<Arguments> provideNegativeNumberCases() {
    return Stream.of(
            Arguments.of("1:-12:3"),
            Arguments.of("//@\n1@-2@3")
    );
  }

  @ParameterizedTest
  @MethodSource("provideNegativeNumberCases")
  @DisplayName("음수를 포함하는 문자열을 입력하면 IllegalArgumentException을 반환한다.")
  void testCalculateWithNegativeNumber(String input) {
    assertThatThrownBy(() -> {
      StringAddCalculator.calculate(input);
    }).isInstanceOf(IllegalArgumentException.class)
      .hasMessage("음수 또는 숫자가 아닌 값이 포함되어 있습니다.");
  }
}