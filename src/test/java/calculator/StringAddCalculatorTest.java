package calculator;

import static calculator.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringAddCalculatorTest {

  @Test
  void null_또는_Space() {
    assertThat(splitAndSum("")).isEqualTo(0);
    assertThat(splitAndSum(null)).isEqualTo(0);
  }

  @Test
  void 문자열_하나() {
    assertThat(splitAndSum("1")).isEqualTo(1);
  }

  @Test
  void 문자열_쉼표_구분자() {
    assertThat(splitAndSum("1,2")).isEqualTo(3);
  }

  @Test
  void 문자열_쉼표_콜론_구분자() {
    assertThat(splitAndSum("1,2:3")).isEqualTo(6);
  }

  @Test
  void 숫자_음수() {
    assertThatThrownBy(() -> splitAndSum("1,2:-3")).isInstanceOf(RuntimeException.class);
  }

  @ParameterizedTest
  @MethodSource("provideSuccessCustomSeparator")
  @DisplayName("커스텀 연산자 성공 케이스 연산 테스트")
  void 커스텀_구분자(String str, int expected) {
    assertThat(splitAndSum(str)).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("provideSuccessCustomSeparator")
  @DisplayName("복잡한 성공 케이스 연산 테스트")
  void complexCalculation(String str, int expected) {
    assertThat(splitAndSum(str)).isEqualTo(expected);
  }

  private static Stream<Arguments> provideSuccessCustomSeparator() {
    return Stream.of(
        Arguments.of("//;\n1,2;3", 6),
        Arguments.of("//;\n1;2:3", 6),
        Arguments.of("//;\n1;2;3", 6),
        Arguments.of("//;\n1,2:3;4", 10)
    );
  }
}
