package camp.nextstep.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

  @Test
  @DisplayName("자동차 게임 라운드 객체 생성")
  void givenNumber_shouldCreatedRound() {
    assertThat(new Round(1)).isEqualTo(new Round(1));
  }

  @Test
  @DisplayName("자동차 게임 라운드 숫자형이 아닌 값 예외")
  void givenNotANumber_shouldException() {
    assertThatThrownBy(() -> new Round("a"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("자동차 게임 라운드 음수 값 예외")
  void givenNegativeNumber_shouldException() {
    assertThatThrownBy(() -> new Round(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }

}