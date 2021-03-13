package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  @DisplayName("입력 문자열 잘라서 계산")
  @Test
  void splitStringCalculate() {
    // given
    String calculateExpression = "2 + 3 * 4 / 2";

    // when
    double result = StringCalculator.calculate(calculateExpression);

    // then
    assertThat(result).isEqualTo(10);
  }

  @DisplayName("입력 값이 null이거나, 공백일때 예외테스트")
  @Test
  void expressionIsEmptyOrIsNull() {
    // given
    String calculateExpression = "2  3 * 4 / 2";

    // when
    Throwable thrown = catchThrowable(() -> {
      StringCalculator.calculate(calculateExpression);
    });

    // then
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

}