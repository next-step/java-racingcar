package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputTest {

  @DisplayName("자동차수 or 이동횟수가 0이면 false 반환한다.")
  @Test
  void valid() {
    Input input = new Input();
    input.enter(0, 0);
    assertThat(input.isValid()).isFalse();
  }

  @DisplayName("자동차수 and 이동횟수가 0이 아니면 true 반환한다.")
  @Test
  void isNotValid() {
    Input input = new Input();
    input.enter(3, 5);
    assertThat(input.isValid()).isTrue();
  }

}