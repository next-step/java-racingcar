package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  Calculator calculator;
  int x;
  int y;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
    x = 4;
    y = 2;
  }

  @Test
  @DisplayName("문자열을 구분하고 덧셈까지 되어야 한다.")
  void add() {
    int actual = calculator.calculate(x + " + " + y);

    assertThat(actual).isEqualTo(x + y);
  }

  @Test
  @DisplayName("뺄셈기능이 동작해야 한다.")
  void subtract() {
    int actual = calculator.calculate(x + " - " + y);

    assertThat(actual).isEqualTo(x - y);
  }

  @Test
  @DisplayName("곱셈기능이 동작해야 한다.")
  void multiply() {
    int actual = calculator.calculate(x + " * " + y);

    assertThat(actual).isEqualTo(x * y);
  }
}
