import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

  @ParameterizedTest
  @DisplayName("숫자 하나를 문자열로 입력하는 경우 해당 숫자를 반환한다.")
  @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
  void oneNumber(String number) {
    int expect = Integer.parseInt(number);
    assertThat(calculator.calculate(number)).isEqualTo(expect);
  }
}