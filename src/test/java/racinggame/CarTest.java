package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

  @DisplayName("자동차 이동 - 이동하지 않는 경우")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  void notMove(int randomValue) {
    final Car car = new Car();
    assertThat(car.move(randomValue)).isEqualTo(1);
  }

  @DisplayName("자동차 이동 - 이동하는 경우")
  @ParameterizedTest
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  void move(int randomValue) {
    final Car car = new Car();
    assertThat(car.move(randomValue)).isEqualTo(2);
  }
}
