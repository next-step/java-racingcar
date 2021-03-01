package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StringUtilsTest {

  static Stream<Arguments> strings() {
    return Stream.of(
        arguments("", true),
        arguments("   ", true),
        arguments(null, true),
        arguments("1 * 3", false));
  }

  @ParameterizedTest
  @DisplayName("빈 문자열 확인")
  @MethodSource("strings")
  void blankString(String input, boolean expected) {
    assertThat(StringUtils.isBlankString(input)).isEqualTo(expected);
  }
}
