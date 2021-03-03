package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static stringcalculator.Operator.DIVIDE;
import static stringcalculator.Operator.MINUS;
import static stringcalculator.Operator.MULTIPLY;
import static stringcalculator.Operator.PLUS;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ExtractorTest {

  static Stream<Arguments> expressionAndExpects() {
    return Stream.of(
        arguments("1 + 2 * 3", Lists.list(1, 2, 3), Lists.list(PLUS, MULTIPLY)),
        arguments("3 + 1 / 2", Lists.list(3, 1, 2), Lists.list(PLUS, DIVIDE)),
        arguments("3 * 4 * 2 - 10", Lists.list(3, 4, 2, 10), Lists.list(MULTIPLY, MULTIPLY, MINUS))
    );
  }

  @ParameterizedTest
  @DisplayName("여러 개의 연산자를 받았을 때 숫자와 연산자를 추출한다.")
  @MethodSource("expressionAndExpects")
  void multipleOperatorExtractNumbers(
      String expression,
      List<Integer> numbers,
      List<Operator> operators) {
    Extractor extractor = new Extractor(StringUtils.split(expression));

    assertAll(
        () -> assertThat(extractor.getNumbers())
            .hasSize(numbers.size())
            .isEqualTo(numbers),
        () -> assertThat(extractor.getOperators())
            .hasSize(operators.size())
            .isEqualTo(operators)
    );
  }
}
