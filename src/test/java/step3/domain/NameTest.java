package step3.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

  @DisplayName("자동차 이름이 5자를 초과 했을때 예외가 발생한다")
  @Test
  void name() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Name("Giannis"))
        .withMessage("자동차 이름은 5자를 초과할 수 없다");
  }


}