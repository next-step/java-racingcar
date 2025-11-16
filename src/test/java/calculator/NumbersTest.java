package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class NumbersTest {

  static Stream<Arguments> sumTestCases() {
    return Stream.of(
        Arguments.of(new String[]{"1"}, 1),
        Arguments.of(new String[]{"1", "2", "3"}, 6)
    );
  }

  @ParameterizedTest
  @MethodSource("sumTestCases")
  void numbersTest(String[] inputs, int expected) {
    Numbers numbers = new Numbers(inputs);
    assertThat(numbers.sum()).isEqualTo(expected);
  }

  @Test
  public void numbersTest_음수() throws Exception {
    String[] inputs = new String[]{"-1", "2", "3"};

    assertThatThrownBy(() -> new Numbers(inputs))
        .isInstanceOf(RuntimeException.class);
  }

}