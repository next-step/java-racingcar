package study1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study1.calculator.CalculatorService;

public class CalculatorTest {
  @ParameterizedTest
  @ValueSource(strings = { "1 - -", "1 0 2" })
  @DisplayName("예외 테스트")
  void checkException(String str) {
    assertThatThrownBy(() -> {
      new CalculatorService(str).calculateAll(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = { "1 + 1:2", "3 - 1:2", "3 * 2:6", "4 / 2:2", "3 + 1 - 2 * 2 / 4:1" }, delimiter = ':')
  @DisplayName("정답 테스트")
  void checkAnswer(String str, int num) {
    int result = new CalculatorService(str).calculateAll(null);
    assertThat(result).isEqualTo(num);
  }
}
