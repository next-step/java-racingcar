package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void moveOrStop_stop() {
    Car notMovedCar = new Car();
    Car car = new Car();
    car.moveOrStop(() -> false);

    assertThat(car).isEqualTo(notMovedCar);
  }

  @Test
  void moveOrStop_move() {
    Car movedCar = new Car(1);
    Car car = new Car();
    car.moveOrStop(() -> true);

    assertThat(car).isEqualTo(movedCar);
  }
}
