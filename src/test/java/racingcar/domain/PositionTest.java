package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

  @DisplayName("자동차의 기본 위치는 0이다.")
  @Test
  void create() {
    Position position = new Position();
    assertThat(position).isEqualTo(new Position(0));
  }

  @DisplayName("자동차의 위치를 한 번 증가시키면 위치가 1만큼 증가한다.")
  @Test
  void increaseOnce() {
    Position position = new Position();
    position.increase();
    assertThat(position).isEqualTo(new Position(1));
  }

  @DisplayName("자동차의 위치를 두 번 증가시키면 위치가 2만큼 증가한다.")
  @Test
  void increaseTwice() {
    Position position = new Position();
    position.increase();
    position.increase();
    assertThat(position).isEqualTo(new Position(2));
  }

}