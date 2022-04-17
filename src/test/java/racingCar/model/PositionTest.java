package racingCar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

  @Test
  @DisplayName("포지션의 위치가 같으면 true를 리턴한다.")
  void samePosition() {
    assertThat(new Position(2)).isEqualTo(new Position(2));
  }

  @Test
  @DisplayName("포지션의 위치가 다르면 false를 리턴한다.")
  void wrongPosition() {
    assertThat(new Position(2)).isNotEqualTo(new Position(3));
  }

  @Test
  @DisplayName("포지션가 정상적으로 출력이 되는지 테스트한다.")
  void positionPrintTest() {
    assertThat(new Position(2).toString()).isEqualTo("--");
  }


}