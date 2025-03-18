package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

public class CarTest {

  Car car = new Car();

  @Test
  void 자동차_멈춤() {
    car.driveOrStop(3);
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @Test
  void 자동차_전진() {
    car.driveOrStop(5);
    assertThat(car.getPosition()).isEqualTo(1);
  }
}

