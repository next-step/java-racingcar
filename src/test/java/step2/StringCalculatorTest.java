package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.validate.StringCalculatorValid;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringCalculatorTest {

  StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @Test
  @DisplayName("덧셈 연산")
  void 덧셈_테스트() {
    assertThat(calculator.add(1, 2)).isEqualTo(3);
  }

  @Test
  @DisplayName("뺄셈 연산")
  void 뺄셈_테스트() {
    assertThat(calculator.subtract(10, 4)).isEqualTo(6);
  }

  @Test
  @DisplayName("곱셈 연산")
  void 곱셈_테스트() {
    assertThat(calculator.multiply(2, 4)).isEqualTo(8);
  }

  @Test
  @DisplayName("나눗셈")
  void 나눗셈_테스트() {
    assertThat(calculator.division(6, 3)).isEqualTo(2);
  }

  @ParameterizedTest
  @DisplayName("입력값이 null이거나 빈 문자열인 경우 예외 처리")
  @CsvSource(value = {"null : 입력값이 없습니다.", "' ': 입력값이 없습니다."}, delimiter = ':')
  void 빈문자열_테스트(String expression, String message) {
    assertThatThrownBy(() -> assertThat(expression)
            .isInstanceOf(IllegalArgumentException.class))
            .overridingErrorMessage(message);
  }

  @Test
  @DisplayName("사칙연산 기호가 아닌 경우 예외 처리")
  void 사칙연산_기호_유효성_테스트() {
    StringCalculatorValid calculatorValid = new StringCalculatorValid();
    String operator = "&";
    assertThatIllegalArgumentException()
            .isThrownBy(() -> assertFalse(calculatorValid.isOperator(operator)))
            .withMessage("사칙연산 기호가 아닙니다");
  }

  @ParameterizedTest
  @DisplayName("사칙연산을 모두 포함하는 기능 구현")
  @ValueSource(strings = {"2 + 3 * 4 / 2"})
  void 사칙연산_모두_포함_테스트(String data) {
    assertThat(calculator.calculator(data)).isEqualTo(10);
  }
}
