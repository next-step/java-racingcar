package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameException;
import racingcar.util.CarNameValidator;

public class CarNameValidatorTest {

  @ParameterizedTest(name = "[CarNameValidator] validateName 테스트 - {index}")
  @ValueSource(strings = {"", "abcdef", "abcdefg"})
  void validateNameTest(String input) {
    assertThatThrownBy(() -> {
      CarNameValidator.validateName(input);
    }).isInstanceOf(CarNameException.class);
  }

}
