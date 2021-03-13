package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.StringUtils;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new StringCalculator();
  }

  @ParameterizedTest
  @CsvSource(value = { "2=2", "2 + 3=5", "2 + 3 * 4=20", "2 + 3 * 4 / 2=10", "2 + 3 * 4 / 2 - 1=9", "2 / 0=0" }, delimiter = '=')
  @DisplayName("문자열 계산기 테스트")
  void calculator(String input, int expected) {
    assertThat(calculator.operation(input))
            .isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource( { "getBlankString" })
  @DisplayName("입력 값 예외 테스트1 - 입력 값이 null or 빈 공백 문자열")
  void checkNotBlankString(final String input) {
    assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
              if (StringUtils.isBlank(input)) {
                throw new IllegalArgumentException();
              }
            });
  }

  private static Stream<String> getBlankString() {
    return Stream.of("", "  ", null);
  }

  @ParameterizedTest
  @ValueSource(strings = { ".", "^" })
  @DisplayName("입력 값 예외 테스트2 - 사칙연산 기호가 아닌 경우 ")
  void checkValidOperationSymbol(final String symbol) {
    assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Operation.of(symbol));
  }
}
