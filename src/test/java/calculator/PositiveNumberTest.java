package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

  @ParameterizedTest
  @ValueSource(strings = {"-1", "a"})
  void create_예외발생(String input) {
    assertThatThrownBy(() -> new PositiveNumber(input))
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void add() {
    PositiveNumber positiveNumber = new PositiveNumber("10");
    assertThat(positiveNumber.add(10)).isEqualTo(20);
  }
}
