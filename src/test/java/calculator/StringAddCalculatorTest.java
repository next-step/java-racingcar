package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

  @DisplayName("빈 문자열이거나 null인 경우 0을 반환")
  @ParameterizedTest
  @NullAndEmptySource
  void blankData(String input) {
    assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
  }

  @DisplayName("디폴트 구분자를 이용한 테스트")
  @ParameterizedTest
  @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
  void usingDefault(String input) {
    assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(6);
  }

  @DisplayName("커스텀 구분자를 이용한 테스트")
  @ParameterizedTest
  @MethodSource("provideInput")
  void usingCustom(String input, int expected) {
    assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideInput() {
    return Stream.of(
        Arguments.of("//;\n1;2;3", 6),
        Arguments.of("//,\n1,2", 3),
        Arguments.of("//@\n3@1@1", 5),
        Arguments.of("//;\n1", 1),
        Arguments.of("2", 2)
    );
  }

  @DisplayName("음수 포함하면 RuntimeException 발생")
  @Test
  void negativeNumber() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> StringAddCalculator.splitAndSum("-1,2:3"));
  }

  @DisplayName("커스텀 구분자에 음수 포함하면 RuntimeException 발생")
  @Test
  void customNegativeNumber() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> StringAddCalculator.splitAndSum("//;\n-1;2;3"));
  }

  @DisplayName("숫자가 아닌값 포함시 RuntimeException 발생")
  @ParameterizedTest
  @ValueSource(strings = {"1:t,3", "1:😱🫣,3", "1,@!@#%^&:3"})
  void invalidNumber(String input) {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> StringAddCalculator.splitAndSum(input));
  }

  @DisplayName("커스텀 구분자에 숫자가 아닌값 포함하면 RuntimeException 발생")
  @ParameterizedTest
  @ValueSource(strings = {"//;\n1;t;3", "//;\n1;😱;3", "//;\n1;@!@#%^&;3"})
  void customInvalidNumber(String input) {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> StringAddCalculator.splitAndSum(input));
  }
}
