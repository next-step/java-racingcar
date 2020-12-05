package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  public static final int NUMBER_OF_CAR = 5;
  private Cars cars;

  @BeforeEach
  void before() {
    cars = new Cars(NUMBER_OF_CAR);
  }

  @DisplayName("모두 이동 가능한 조건이라, 이동한 경우")
  @Test
  public void canMoveIsTrue() {
    cars.race(new TestAllTrueRacingRule());
    assertThat(cars.getCars().size()).isEqualTo(NUMBER_OF_CAR);
    for (Car car : cars.getCars()) {
      assertThat(car.getDistance()).isEqualTo(Car.INIT_POSITION + 1);
    }
  }

  @DisplayName("모두 이동 가능하지 못한 조건이라, 이동 못한 경우")
  @Test
  public void canMoveIsFalse() {
    cars.race(new TestAllFalseRacingRule());
    assertThat(cars.getCars().size()).isEqualTo(NUMBER_OF_CAR);
    for (Car car : cars.getCars()) {
      assertThat(car.getDistance()).isEqualTo(Car.INIT_POSITION);
    }
  }
}
