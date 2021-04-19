package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.MovableStrategy;

public class CarMovableStrategyTest {

  @DisplayName("랜덤 숫자가 4 이상일 경우 이동가능한지")
  @Test
  void carPositionNumberIsMove() {
    // given
    int MOVE_CONDITION_NUM = 4;
    int randomNumber = (int) (Math.random() * 10 + 4);

    MovableStrategy movableStrategy = () -> randomNumber >= MOVE_CONDITION_NUM;

    // when
    boolean isMovable = movableStrategy.isMovable();

    // then
    assertThat(isMovable).isTrue();
  }

  @DisplayName("랜덤 숫자가 4 미만일 경우 이동 실패하는지 테스트")
  @Test
  void carMoveFail() {
    // given
    int MOVE_CONDITION_NUM = 4;
    int randomNumber = (int) (Math.random() + 3);
    MovableStrategy movableStrategy = () -> randomNumber >= MOVE_CONDITION_NUM;

    // when
    boolean isMovable = movableStrategy.isMovable();

    // then
    assertThat(isMovable).isFalse();
  }

}
