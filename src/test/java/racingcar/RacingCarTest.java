package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.NormalMoveStrategy;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

  @Test
  @DisplayName("CarInterface 상속으로 RacingCar 객체 생성 후 position = 0인지 확인")
  public void createRacingCar_ReturnPositionValueZero() {
    RacingCar racingCar = new RacingCar();
    int result = racingCar.position();

    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("전략패턴을 통한 RacingCar move 실행후 position = 1인지 확인")
  public void moveRacingCar_ReturnPositionValueOne() {
    RacingCar racingCar = new RacingCar();
    MoveStrategy normalMoveStrategy = new NormalMoveStrategy();

    racingCar.tryToMove(normalMoveStrategy);

    int result = racingCar.position();

    assertThat(result).isEqualTo(1);
  }
}