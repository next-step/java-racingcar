package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringCalculatorTest {
  private StringCalculator calculator;
  
  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }
  
  @ParameterizedTest
  @DisplayName("빈 칸과 3개 미만 입력에 대한 예외 테스트")
  @ValueSource(strings = {"", "  ", "1", " 1 2"})
  public void 입력_예외테스트(String input){
    // given & when
    Throwable thrown = catchThrowable(() -> { calculator.calculate(input); });
    // then
    Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }
  
  @ParameterizedTest
  @DisplayName("사칙연산을 사용한 계산 테스트")
  @CsvSource(value = {"1 + 2 = 3", "1 + 2 * 3 = 9", "2 + 4 / 3 = 2", "5 - 5 / 10 = 0"}, delimiter = '=')
  public void 계산테스트(String input, int expected) {
    // give & when
    int result = calculator.calculate(input);
    // then
    assertThat(result).isEqualTo(expected);
  }
  
  @Test
  @DisplayName("0으로 나눌때 예외 테스트")
  public void 나누기_예외테스트() {
    assertThatThrownBy(() -> {
      calculator.calculate(" 1 / 0 ");
    }).isInstanceOf(ArithmeticException.class);
  }

  @ParameterizedTest
  @DisplayName("다른 기호에 대한 예외 테스트")
  @ValueSource(strings = {"r", "#"})
  void 연산기호_예외테스트(String input) {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Operator.convertOperator(input));
  }
}