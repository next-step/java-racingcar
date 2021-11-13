package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RacingCarTest {

  @Test
  public void moveRacingCarTest() {
    RacingCar car = new RacingCar(0);
    car.tryMove(8);
    assertThat(car.getMoveCount()).isEqualTo(1);
  }

  @Test
  public void notMoveRacingCarTest() {
    RacingCar car = new RacingCar(0);
    car.tryMove(2);
    assertThat(car.getMoveCount()).isEqualTo(0);
  }
}
