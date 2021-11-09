import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

  @ParameterizedTest
  @DisplayName("기본 산술 테스트")
  @CsvSource(value = {"1 + 2|3", "2 - 1|1", "3 * 2|6", "4 / 2|2"}, delimiter = '|')
  void testOperator(String input, String result) {
    // given
    // when
    String calculate = new Calculator().calculate(input);
    // then
    assertThat(calculate).isEqualTo(result);
  }
}