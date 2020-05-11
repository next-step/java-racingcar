package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @DisplayName("문자열 계산기 테스트")
  @Test
  void 사칙연산_테스트_01 () {
     calculator.getExpression("2 + 3 + 4 + 5");
     assertThat(2 + 3 + 4 + 5).isEqualTo(calculator.getResult());
  }

  @DisplayName("문자열 계산기 멀티 테스트")
  @ParameterizedTest
  @CsvSource(value = {
    "2 + 3 + 4 + 5,14",
    "2 - 3 - 4 - 5,-10",
    "2 * 3 * 4 * 5,120",
    "6 / 6,1"
  })
  void 사칙연산_테스트 (String expression, int expected) {
    calculator.getExpression(expression);
    assertThat(expected).isEqualTo(calculator.getResult());
  }
}
