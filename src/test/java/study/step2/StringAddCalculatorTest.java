package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

  @Test
  @DisplayName("구분자가 없는 빈문자열인 경우 default value 리턴 테스트")
  void separatorTest1() {
    String given = "";
    assertThat(StringAddCalculator.splitAndSum(given))
        .isEqualTo(StringAddCalculator.getDefaultResult());
  }

  @Test
  @DisplayName("주어진 값이 null 인 경우, default value 리턴 테스트")
  void separatorTest2() {
    String given = null;
    assertThat(StringAddCalculator.splitAndSum(given))
        .isEqualTo(StringAddCalculator.getDefaultResult());
  }

  @Test
  @DisplayName("숫자 하나를 입력한 경우, 해당 숫자 리턴 테스트")
  void separatorTest3() {
    String given = "1";
    assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(1);
  }

  @Test
  @DisplayName("쉼표를 구분자로 가진 문자열 덧셈 테스트")
  void separatorTest4() {
    String given = "1,2";
    assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(3);
  }

  @Test
  @DisplayName("콜론을 구분자로 가진 문자열 덧셈 테스트")
  void separatorTest5() {
    String given = "1:2:3";
    assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(6);
  }

  @Test
  @DisplayName("쉼표와 콜론을 구분자로 가진 문자열 덧셈 테스트")
  void separatorTest6() {
    String given = "1,2:3,4";
    assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(10);
  }

  @Test
  @DisplayName("음수를 전달할 경우 RuntimeException 예외 테스트")
  void separatorTest7() {
    String given = "-1,2,3";
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum(given))
        .isInstanceOfAny(RuntimeException.class);
  }

  @Test
  @DisplayName("정의하지 않은 구분자가 포함된 문자열을 전달할 경우 NumberFormatException 예외 테스트")
  void separatorTest8() {
    String given = "1,2,3=4";
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum(given))
        .isInstanceOfAny(NumberFormatException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "1-1",
      "1,2-3",
      "1:2:3-6",
      "1,2:3,4-10"
  }, delimiter = '-')
  @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
  void parameterizedTest(String given, int expected) {
    assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(expected);
  }

  @NullAndEmptySource
  @ParameterizedTest
  @DisplayName("빈문자열 혹은 null 인 경우, default value 리턴 테스트")
  void parameterizedTest2(String given) {
    assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(StringAddCalculator.getDefaultResult());
  }

  @ParameterizedTest
  @MethodSource("getTestCases")
  @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
  void methodSourceTest(String given, int expected) {
    assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(expected);
  }

  private static Stream<Arguments> getTestCases() {
    return Stream.of(
        Arguments.of("1", 1),
        Arguments.of("1,2", 3),
        Arguments.of("1:2:3", 6),
        Arguments.of("1,2:3,4", 10)
    );
  }
}
