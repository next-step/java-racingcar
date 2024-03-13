package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.domain.strategy.RandomCarMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCarMoveStrategyTest {

  private final RandomCarMoveStrategy randomCarMoveStrategy = new RandomCarMoveStrategy();

  @Test
  @DisplayName("isMovable(): 랜덤 값에 따라 true 또는 false를 반환합니다.")
  void isMovableTest() {
    assertThat(randomCarMoveStrategy.isMovable()).isIn(true, false);
  }
}
