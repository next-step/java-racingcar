package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

  Calculator calculator;
  int x;
  int y;

  static Stream<String> blankStrings() {
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
  @DisplayName("blank로 간주할 수 있는 문자열이 입력될 경우 예외가 발생한다.")
  @MethodSource("blankStrings")
  void blankStringInput(String expression) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> calculator.calculate(expression))
        .withMessage("식을 입력해주세요.");
  }

  @ParameterizedTest
  @DisplayName("지원하지 않는 연산자를 사용하는 경우 예외가 발생한다.")
  @ValueSource(strings = {"2 & 3", "2 ^ 7", "4 % 2"})
  void wrongOperator(String expression) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> calculator.calculate(expression))
        .withMessage("해당 연산자는 지원하지 않습니다.");
  }
}
