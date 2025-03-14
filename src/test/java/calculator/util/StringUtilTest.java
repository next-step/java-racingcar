package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {
  static Stream<Arguments> provideIsNullOrEmptyCases() {
    return Stream.of(
            Arguments.of(null, true),
            Arguments.of("", true),
            Arguments.of(" ", false),
            Arguments.of("a", false)
    );
  }

  @ParameterizedTest
  @MethodSource("provideIsNullOrEmptyCases")
  @DisplayName("문자열이 null 또는 빈 문자열인지 확인한다.")
  void testIsNullOrEmpty(String input, boolean expected){
    System.out.println("input = " + input);
    boolean result = StringUtil.isNullOrEmpty(input);
    assertEquals(expected, result);
  }

  static Stream<Arguments> provideAddNumbersInArrayCases() {
    return Stream.of(
            Arguments.of(List.of("1", "2", "3"), 6),
            Arguments.of(List.of("2", "3", "4"), 9),
            Arguments.of(List.of("3", "4", "5"), 12),
            Arguments.of(List.of("1"), 1),
            Arguments.of(List.of(), 0)
    );
  }

  @ParameterizedTest
  @MethodSource("provideAddNumbersInArrayCases")
  @DisplayName("문자열을 숫자로 변환하여 더한 값을 반환한다.")
  void testAddNumbersInArray(List<String> numbers, int expected){
    int result = StringUtil.addNumbersInArray(numbers);
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("음수가 포함된 문자열을 입력하면 IllegalArgumentException을 반환한다.")
  void testAddNumbersInArrayWithNegativeNumberThrowsException() {
    assertThatThrownBy(() -> {
      StringUtil.addNumbersInArray(List.of("1, -1"));
    }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("음수 또는 숫자가 아닌 값이 포함되어 있습니다.");
  }

  @Test
  @DisplayName("숫자가 아닌 값이 포함된 문자열을 입력하면 IllegalArgumentException을 반환한다.")
  void testAddNumbersInArrayWithNonNumericThrowsException() {
    assertThatThrownBy(() -> {
      StringUtil.addNumbersInArray(List.of("1, a"));
    }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("음수 또는 숫자가 아닌 값이 포함되어 있습니다.");
  }


}