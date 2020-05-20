package step3;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RacingCarTest {
  RacingCar racingCar = new RacingCar();

  @Test
  void move() {
    racingCar.move();
    assertThat(racingCar.getDistance()).isEqualTo(1);
  }
}
