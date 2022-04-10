package calculator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

  @ParameterizedTest
  @NullAndEmptySource
  public void splitAndSum_null_또는_빈문자(String input) {
    assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
  }

  @Test
  public void splitAndSum_숫자하나() {
    int result = StringAddCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,3*6", "1:2*3", "1,2:3*6"}, delimiter = '*')
  public void splitAndSum_기본구분자(String input, int expectedValue) {
    assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expectedValue);
  }

  @Test
  public void splitAndSum_custom_구분자() {
    int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  public void splitAndSum_두자리수() {
    int result = StringAddCalculator.splitAndSum("//;\n50;20;30");
    assertThat(result).isEqualTo(100);
  }

  @ParameterizedTest
  @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3"})
  public void splitAndSum_negative(String input) {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
        .isInstanceOf(RuntimeException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"abc", "1,2,a", "a,1,2"})
  public void splitAndSum_not_number(String input) {
    assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
        .isInstanceOf(RuntimeException.class);
  }
}
