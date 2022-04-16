package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

  private Cars cars;

  @BeforeEach
  void setup() {
    cars = Cars.createCars(5);
  }

  @Test
  void makeCars() {
    Cars testCars = Cars.createCars(10);
    assertThat(testCars.size()).isEqualTo(10);
  }

  @Test
  void allMove() {
    cars.move(() -> true);

    assertThat(cars.collectPositions()).hasSize(cars.size());
    assertThat(cars.collectPositions()).containsExactly(1, 1, 1, 1, 1);
  }

  @Test
  void allStop() {
    cars.move(() -> false);

    assertThat(cars.collectPositions()).hasSize(cars.size());
    assertThat(cars.collectPositions()).containsExactly(0, 0, 0, 0, 0);
  }
}
