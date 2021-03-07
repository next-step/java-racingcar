package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car();
  }

  @DisplayName("주어진 숫자가 4 이상이면 이동")
  @ParameterizedTest
  @ValueSource(ints = {4,5,6,7,8,9})
  void given_number_greater_3_car_move(int number) {
    car.move(number);
    assertThat(car.getDistance()).isEqualTo(1);
  }

  @DisplayName("주어진 숫자가 4 미만이면 정지")
  @ParameterizedTest
  @ValueSource(ints = {0,1,2,3})
  void given_number_less_4_car_move(int number) {
    car.move(number);
    assertThat(car.getDistance()).isEqualTo(0);
  }

}
