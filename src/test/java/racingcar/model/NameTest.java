package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  @ParameterizedTest
  @ValueSource(strings = {"", "가나다라마바"})
  void createFail(String value) {
    assertThatThrownBy(() -> new Name(value)).isInstanceOf(IllegalArgumentException.class);
  }
}
