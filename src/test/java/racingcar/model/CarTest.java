package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void moveOrStop_stop() {
    Car car = new Car("yeny", 0);
    car.moveOrStop(() -> false);

    Car notMovedCar = new Car("yeny", 0);
    assertThat(car).isEqualTo(notMovedCar);
  }

  @Test
  void moveOrStop_move() {
    Car car = new Car("yeny", 0);
    car.moveOrStop(() -> true);

    Car movedCar = new Car("yeny", 1);
    assertThat(car).isEqualTo(movedCar);
  }
}
