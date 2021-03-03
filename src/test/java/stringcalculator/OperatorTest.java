package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OperatorTest {

  static final int x = 6;
  static final int y = 2;

  static Stream<Arguments> operatorPairs() {
    return Stream.of(
        arguments("+", Operator.PLUS),
        arguments("-", Operator.MINUS),
        arguments("*", Operator.MULTIPLY),
        arguments("/", Operator.DIVIDE)
    );
  }

  static Stream<Arguments> operatorAndResult() {
    return Stream.of(
        arguments(Operator.PLUS, x + y),
        arguments(Operator.MINUS, x - y),
        arguments(Operator.MULTIPLY, x * y),
        arguments(Operator.DIVIDE, x / y)
    );
  }

  @ParameterizedTest
  @DisplayName("Operator 생성 테스트")
  @MethodSource("operatorPairs")
  void operatorCreation(String operator, Operator expected) {
    assertThat(Operator.operatorOf(operator)).isEqualTo(expected);
  }

  @Test
  @DisplayName("Operator 생성 실패 테스트")
  void operatorCreationFail() {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Operator.operatorOf("&"))
        .withMessage("해당 연산자는 지원하지 않습니다.");
  }

  @ParameterizedTest
  @DisplayName("Operator 연산 테스트")
  @MethodSource("operatorAndResult")
  void operate(Operator operator, int result) {
    assertThat(operator.operate(x, y)).isEqualTo(result);
  }
}
