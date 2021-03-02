package stringcalculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ValidatorTest {

  static Stream<String> strings() {
    return Stream.of("", "    ", null);
  }

  @ParameterizedTest
  @DisplayName("입력된 식을 검증한다.")
  @MethodSource("strings")
  void validate(String expression) {
    assertThatIllegalArgumentException()
        .isThrownBy(() -> Validator.validateExpression(expression))
        .withMessage("식을 입력해주세요.");
  }
}
