package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  @DisplayName("입력 문자열 잘라서 계산")
  @Test
  void splitStringCalculate() {
    // given
    String calculateExpression = "2 + 3 * 4 / 2";

    // then
    double result = StringCalculator.calculate(calculateExpression);

    // then
    assertThat(result).isEqualTo(10);
  }

}