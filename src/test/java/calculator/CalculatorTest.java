package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

  @ParameterizedTest(name = "[Calculator] 사칙연산 테스트  - {index}")
  @CsvSource(value = {"2 + 3 * 4 / 2 - 1:9", "4 * 3 + 4 - 1 / 3:5", "2 + 3 - 4 * 10 / 2:5"}, delimiter = ':')
  void calculatorTest(String input, int expected) {
    Calculator calc = new Calculator();

    assertThat(calc.calculate(input)).isEqualTo(expected);
  }

}
