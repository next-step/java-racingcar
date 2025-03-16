package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

  @Test
  @DisplayName("자동차는 전진할 수 있다.")
  void move() {
    RacingCar car = new RacingCar();
    car.move();
    assertThat(car.getPosition()).isEqualTo(1);
  }

}
