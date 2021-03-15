package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  private static final String TEST_CAR = "TEST";
  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car(TEST_CAR);
  }

  @DisplayName("자동차가 움직이는 경우")
  @Test
  void move_test() {
    car.move(() -> true);
    assertThat(car.getDistance()).isEqualTo(1);
  }

  @DisplayName("자동차가 안움직이는 경우")
  @Test
  void not_move_test() {
    car.move(() -> false);
    assertThat(car.getDistance()).isEqualTo(0);
  }

}
