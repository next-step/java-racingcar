package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringAddCalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  void splitAndSum_null_또는_빈문자(String input) {
    assertThat(StringAddCalculator.splitAndSum(input)).isZero();
  }

  @Test
  void splitAndSum_숫자하나() {
    int result = StringAddCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,3*6", "1:2*3", "1,2:3*6"}, delimiter = '*')
  void splitAndSum_기본구분자(String input, int expectedValue) {
    assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expectedValue);
  }

  @Test
  void splitAndSum_custom_구분자() {
    int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  void splitAndSum_두자리수() {
    int result = StringAddCalculator.splitAndSum("//;\n50;20;30");
    assertThat(result).isEqualTo(100);
  }
}
