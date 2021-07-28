package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

  @DisplayName("입력(시도 횟수) 값이 양수가 아닐 경우 예외가 발생한다")
  @Test
  void input() {

    Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Input("pobi,crong,honux", 0))
        .withMessageContaining("입력 값은 양의 정수여야 한다");
  }
}