package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameException;
import racingcar.model.Name;

public class NameTest {

  @ParameterizedTest(name = "[Name] validateName 테스트 - {index}")
  @ValueSource(strings = {"", "abcdef", "abcdefg"})
  void validateNameTest(String input) {
    assertThatThrownBy(() -> {
      new Name(input);
    }).isInstanceOf(CarNameException.class);
  }
}
