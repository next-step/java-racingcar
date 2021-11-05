package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

  @ParameterizedTest
  @CsvSource(value = {"+:SUM", "-:SUB", "*:MULTIPLY", "/:DIVIDE"}, delimiter = ':')
  @DisplayName("사칙연산 기호일 경우 해당하는 enum type의 연산자를 반환한다.")
  void operatorTest(String input, Operator operator) {
    assertThat(Operator.of(input)).isEqualTo(operator);
  }

  @ParameterizedTest
  @ValueSource(strings = {" ", "q", "^"})
  @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException를 던진다.")
  void wrongOperatorTest(String input) {
    assertThatIllegalArgumentException().isThrownBy(() -> Operator.of(input));
  }
}