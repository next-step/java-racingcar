package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
  @Test
  void nullOrBlank() {
    int result1 = StringAddCalculator.splitAndSum(null);
    assertThat(result1).isEqualTo(0);
    int result2 = StringAddCalculator.splitAndSum("");
    assertThat(result2).isEqualTo(0);
    int result3 = StringAddCalculator.splitAndSum(" ");
    assertThat(result3).isEqualTo(0);
  }

  @Test
  void colonSeparator() {
    int result = StringAddCalculator.splitAndSum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  void commaSeparator() {
    int result = StringAddCalculator.splitAndSum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @Test
  void returnNumber() {
    int result = StringAddCalculator.splitAndSum("1");
    assertThat(result).isEqualTo(1);
  }
}
