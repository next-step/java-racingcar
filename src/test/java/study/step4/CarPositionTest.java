package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step4.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.step4.domain.Position.CAR_POSITION_CAN_NOT_BE_NEGATIVE;
import static racingcar.step4.domain.Position.DEFAULT_START_POSITION;

public class CarPositionTest {

  @Test
  @DisplayName("자동차 위치가 음수일 경우 에러 발생")
  void carPositionTest() {
    assertThatThrownBy(() -> Position.specificPosition(-1))
        .isInstanceOfAny(IllegalArgumentException.class)
        .hasMessageContaining(CAR_POSITION_CAN_NOT_BE_NEGATIVE);
  }

  @Test
  @DisplayName("자동차 위치가 양수일 경우 정상 생성")
  void carPositionTest2() {
    assertThat(Position.specificPosition(10).get()).isEqualTo(10);
  }

  @Test
  @DisplayName("자동차 위치를 기본 위치 생성자를 이용할 경우 DEFAULT_START_POSITION 으로 셋팅")
  void carPositionTest3() {
    assertThat(Position.defaultPosition().get()).isEqualTo(DEFAULT_START_POSITION);
  }
}
