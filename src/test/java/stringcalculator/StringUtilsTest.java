package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static stringcalculator.StringUtils.DELIMITER;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringUtilsTest {

  static Stream<Arguments> strings() {
    return Stream.of(
        arguments("", true),
        arguments("   ", true),
        arguments(null, true),
        arguments("1 * 3", false));
  }

  static Stream<Arguments> expressionAndNumbers() {
    return Stream.of(
        arguments("1 + 2 * 3", Lists.list(1, 2, 3)),
        arguments("3 + 1 / 2", Lists.list(3, 1, 2)),
        arguments("3 * 4 * 2 - 10", Lists.list(3, 4, 2, 10))
    );
  }

  @ParameterizedTest
  @DisplayName("빈 문자열 확인")
  @MethodSource("strings")
  void blankString(String input, boolean expected) {
    assertThat(StringUtils.isBlankString(input)).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("문자열이 공백문자로 분리되는지 확인")
  @ValueSource(strings = {
      "1 * 3",
      "1 / 3",
      "1 + 2 * 3"})
  void split(String expression) {
    String[] expected = expression.split(DELIMITER);

    assertThat(StringUtils.split(expression))
        .usingFieldByFieldElementComparator()
        .isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("여러 개의 연산자를 받았을 때 숫자만 추출해서 반환한다.")
  @MethodSource("expressionAndNumbers")
  void multipleOperatorExtractNumbers(String expression, List<Integer> expected) {
    assertThat(StringUtils.extractNumbers(expression))
        .hasSize(expected.size())
        .isEqualTo(expected);
  }
}
