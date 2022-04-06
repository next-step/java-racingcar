import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  private void init() {
    calculator = new StringCalculator();
  }

  @Test
  @DisplayName("빈 문자열 또는 null값을 입력할 경우 0을 반환해야 한다.")
  void zeroReturn() {
    int expect = 0;
    assertThat(calculator.calculate("")).isEqualTo(expect);
    assertThat(calculator.calculate(null)).isEqualTo(expect);
  }
}