package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CalculatorTest {

  Calculator calculator;
  int x;
  int y;

  static Stream<String> emptyStrings() {
    return Stream.of("", "     ", null);
  }

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
    x = 6;
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

  @Test
  @DisplayName("나눗셈기능이 동작해야 한다.")
  void divide() {
    int actual = calculator.calculate(x + " / " + y);

    assertThat(actual).isEqualTo(x / y);
  }

  @ParameterizedTest
  @DisplayName("empty로 간주할 수 있는 문자열이 입력될 경우 예외가 발생한다.")
  @MethodSource("emptyStrings")
  void emptyStringInput(String expression) {
    assertThatThrownBy(() -> calculator.calculate(expression))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("식을 입력해주세요.");
  }
}
