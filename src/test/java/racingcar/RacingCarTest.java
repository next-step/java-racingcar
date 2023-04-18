package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;
import step2.study.StringAddCalculator2;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

public class RacingCarTest {

  @Test
  @DisplayName("RacingCar 객체 생성 후 position = 0인지 확인")
  public void createRacingCar_ReturnPositionValueZero() {
    RacingCar racingCar = new RacingCar("test");
    int result = racingCar.position();

    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("전략패턴을 통한 RacingCar move 실행후 position = 1인지 확인")
  public void moveRacingCar_ReturnPositionValueOne() {
    RacingCar racingCar = new RacingCar("test");
    MoveStrategy randomMoveStrategy = new RandomMoveStrategy();

    racingCar.tryToMove(randomMoveStrategy);

    int result = racingCar.position();

    assertThat(result).isEqualTo(1);
  }

  @Test
  @DisplayName("RacingCar 객체 생성 후 name = test 인지 확인")
  public void createRacingCar_ReturnNameTest() {
    RacingCar racingCar = new RacingCar("test");
    String result = racingCar.name();

    assertThat(result).isEqualTo("test");
  }

  @Test
  @DisplayName("RacingCar 객체 생성 후 name > 5 IllegalArgumentException 발생")
  public void carNameOverTheFive_ThrowException() {
    assertThatCode(() -> {
              RacingCar racingCar = new RacingCar("test23");
    }).isInstanceOf(IllegalArgumentException.class);
  }
}