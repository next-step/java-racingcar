package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
  @Test
  void negativeInteger() {
    assertThatThrownBy(() ->
      StringAddCalculator.splitAndSum("1,-2,3")
    ).isInstanceOf(RuntimeException.class);
  }

  @Test
  void customDelimiter() {
    int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @Test
  void nullOrBlank() {
    int nullResult = StringAddCalculator.splitAndSum(null);
    assertThat(nullResult).isEqualTo(0);
    int emptyResult = StringAddCalculator.splitAndSum("");
    assertThat(emptyResult).isEqualTo(0);
    int whiteSpaceResult = StringAddCalculator.splitAndSum(" ");
    assertThat(whiteSpaceResult).isEqualTo(0);
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
