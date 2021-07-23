package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

  @DisplayName("입력 값이 양수가 아닐 경우 예외가 발생한다")
  @Test
  void input() {

    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Input(0, 5))
        .withMessageContaining("입력 값은 양의 정수여야 한다");
  }
}