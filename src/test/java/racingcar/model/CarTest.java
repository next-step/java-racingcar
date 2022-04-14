package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  void moveOrStop_stop() {
    Car car = new Car();
    car.moveOrStop(3);
    assertThat(car.getPosition()).isZero();
  }

  @Test
  void moveOrStop_move() {
    Car car = new Car();
    car.moveOrStop(4);
    assertThat(car.getPosition()).isEqualTo(1);
  }
}
