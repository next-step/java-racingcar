package study;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputExpressionParserTest {

  @ParameterizedTest
  @CsvSource(value = {"' ',입력값이 비어있습니다.", ",입력값이 비어있습니다."})
  @DisplayName("입력값이 비어있는 경우 에러를 리턴한다.")
  void validateExpressionWitheSpace(String expression, String errorMessage) {
    assertThatThrownBy(() -> new InputExpressionParser(expression))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching(errorMessage);
  }

  @ParameterizedTest
  @CsvSource(value = {"* 1 + 3,올바른 입력값이 아닙니다.", "1 4 +,올바른 입력값이 아닙니다.", "1 * 2 + 9 -,올바른 입력값이 아닙니다."})
  @DisplayName("올바른 입력값이 아니면 에러를 리턴한다.")
  void validateExpressionStartNumberTest(String expression, String errorMessage) {
    assertThatThrownBy(() -> new InputExpressionParser(expression))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageMatching(errorMessage);
  }

}