package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

  @DisplayName("빈 문자열이거나 null인 경우 0을 반환")
  @Test
  void blankData() {
    assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
    assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
  }

  @DisplayName("쉼표 구분자인 경우")
  @Test
  void usingComma() {
    assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
  }

  @DisplayName("콜론 구분자를 사용")
  @Test
  void usingColon() {
    assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
  }

  @DisplayName("쉼표와 콜론 구분자를 같이 사용")
  @Test
  void usingCommaAndColon() {
    assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
  }

  @DisplayName("//와 \n문자 사이에 커스텀 구분자를 지정")
  @Test
  void usingCustom() {
    assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
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

  @DisplayName("구분자에 숫자가 아닌값 포함하면 RuntimeException 발생")
  @Test
  void invalidNumber() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> StringAddCalculator.splitAndSum("1:t,3"));
  }

  @DisplayName("커스텀 구분자에 숫자가 아닌값 포함하면 RuntimeException 발생")
  @Test
  void customInvalidNumber() {
    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> StringAddCalculator.splitAndSum("//;\n1;t;3"));
  }

  @DisplayName("숫자 하나를 문자열로 입력")
  @Test
  void onlyOneNumber() {
    assertThat(StringAddCalculator.splitAndSum("//;\n1")).isEqualTo(1);
    assertThat(StringAddCalculator.splitAndSum("2")).isEqualTo(2);
  }
}
