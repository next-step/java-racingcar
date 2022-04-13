package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  @ParameterizedTest
  @ValueSource(ints = {0, 1, 2, 3})
  void moveOrStop_stop(int number) {
    Car car = new Car();
    car.moveOrStop(number);
    assertThat(car.getPosition()).isZero();
  }

  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void moveOrStop_move(int number) {
    Car car = new Car();
    car.moveOrStop(number);
    assertThat(car.getPosition()).isEqualTo(1);
  }
}
