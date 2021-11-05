import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  @DisplayName("덧셈")
  void testAdd() {
    // given
    String input = "1 + 2";
    // when
    String calculate = Calculator.calculate(input);
    // then
    assertThat(calculate).isEqualTo("3");
  }

  @Test
  @DisplayName("덧셈")
  void testSubtraction() {
    // given
    String input = "2 - 1";
    // when
    String calculate = Calculator.calculate(input);
    // then
    assertThat(calculate).isEqualTo("1");
  }

  @Test
  @DisplayName("곱셈")
  void testMultiplication() {
    // given
    String input = "3 * 2";
    // when
    String calculate = Calculator.calculate(input);
    // then
    assertThat(calculate).isEqualTo("6");
  }

  @Test
  @DisplayName("나눗셈")
  void testDivision() {
    // given
    String input = "4 / 2";
    // when
    String calculate = Calculator.calculate(input);
    // then
    assertThat(calculate).isEqualTo("2");
  }

  @Test
  @DisplayName("0으로 나눌 경우")
  void testDivision_divideByZero() {
    // given
    String input = "1 / 0";
    // when
    ThrowingCallable lambdaToTest = () -> Calculator.calculate(input);
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
    ThrowingCallable lambdaToTest = () -> Calculator.calculate(input);
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
    ThrowingCallable lambdaToTest = () -> Calculator.calculate(input);
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
    String calculate = Calculator.calculate(input);
    // then
    assertThat(calculate).isEqualTo("10");
  }
}