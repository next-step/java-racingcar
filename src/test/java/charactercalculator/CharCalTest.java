package charactercalculator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import chactercalculator.Calculator;
import chactercalculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("2단계 문자열 계산기 테스트")
public class CharCalTest {

  Calculator calculator = new Calculator();

  @DisplayName("하나의 연산자를 활용한 계산 테스트")
  @ParameterizedTest
  @CsvSource({"'5 + 5', 10", "'1 + 3', 4", "'9 - 4', 5", "'5 - 5', 0", "'1 * 3', 3", "'4 * 3', 12",
      "'8 / 2', 4", "'6 / 3', 2"})
  void 단일_연산자로_계산된다(String given, Integer expected) {
    assertThat(calculator.calculate(given)).isEqualTo(expected);
  }
}
