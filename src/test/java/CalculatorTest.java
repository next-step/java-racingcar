import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  @DisplayName("0으로 나눌 경우")
  void testDivision_divideByZero() {
    // given
    String input = "1 / 0";
    // when
    ThrowingCallable lambdaToTest = () -> new Calculator().calculate(input);
    // then
    assertThatThrownBy(lambdaToTest)
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("입력값이 null 일 경우")
  void testDivision_calculateNull() {
    // given
    String input = "1 / ";
    // when
    ThrowingCallable lambdaToTest = () -> new Calculator().calculate(input);
    // then
    assertThatThrownBy(lambdaToTest)
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("사칙연산 기호가 아닌 경우")
  void testDivision_calculateWithIllegalOperator() {
    // given
    String input = "4 & 2";
    // when
    ThrowingCallable lambdaToTest = () -> new Calculator().calculate(input);
    // then
    assertThatThrownBy(lambdaToTest)
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("사칙 연산을 모두 포함하는 기능 구현")
  void testCalculate() {
    // given
    String input = "2 + 3 * 4 / 2";
    // when
    String calculate = new Calculator().calculate(input);
    // then
    assertThat(calculate).isEqualTo("10");
  }
}