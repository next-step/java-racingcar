package study1.calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
  @ParameterizedTest
  @ValueSource(strings = { "1 - -", "1 0 2" })
  @DisplayName("예외 테스트")
  void checkException(String str) {
    assertThatThrownBy(() -> {
      new CalculatorService(str).calculateAll();
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = { "1 + 1:2", "3 - 1:2", "3 * 2:6", "4 / 2:2", "3 + 1 - 2 * 2 / 4:1" }, delimiter = ':')
  @DisplayName("정답 테스트")
  void checkAnswer(String str, int num) {
    int result = new CalculatorService(str).calculateAll();
    assertThat(result).isEqualTo(num);
  }

  @ParameterizedTest
  @MethodSource("generateMarkAndNum")
  @DisplayName("calculate 테스트")
  void checkCalculate(String mark, int num1, int num2, int total) {
    int result = CalculatorEnum.fromMark(mark).calculate(num1, num2);
    assertThat(result).isEqualTo(total);
  }

  private static Stream<Arguments> generateMarkAndNum() {
    return Stream.of(
      Arguments.of("+", 1, 1, 2), 
      Arguments.of("-", 1, 1, 0),
      Arguments.of("*", 2, 2, 4),
      Arguments.of("/", 6, 2, 3)
    );
  }
}
