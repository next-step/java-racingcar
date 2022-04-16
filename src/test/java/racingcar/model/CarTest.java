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

  @Test
  void compareTo_positive() {
    Car movedCar = new Car("yeny", 1);
    Car notMovedCar = new Car("yeeun", 0);

    assertThat(movedCar.compareTo(notMovedCar)).isPositive();
    assertThat(notMovedCar.compareTo(movedCar)).isNegative();
  }

  @Test
  void hasSamePosition() {
    Car car1 = new Car("yeny", 0);
    Car car2 = new Car("yeeun", 0);

    assertThat(car1.hasSamePosition(car2)).isTrue();
  }

  @Test
  void createOutput() {
    Car car = new Car("yeny", 3);

    assertThat(car.createOutput()).isEqualTo("yeny : ---");
  }
}
