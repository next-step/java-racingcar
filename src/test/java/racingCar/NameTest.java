package racingCar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.domain.Name;
import racingCar.domain.OverCarNameLengthException;

public class NameTest {

  @DisplayName("이름 길이가 5글자를 초과하면 안된다.")
  @Test
  void more_five_length_throw_Exception() {
    assertThatThrownBy(() -> new Name("jdragon")).isInstanceOf(OverCarNameLengthException.class);
  }

}
