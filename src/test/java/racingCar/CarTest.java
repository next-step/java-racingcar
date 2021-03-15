package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  private static final String TEST_CAR = "TEST";

  @DisplayName("자동차가 움직이는 경우")
  @Test
  void move_test() {
    Car car = new Car(TEST_CAR, 0);
    car.move(() -> true);
    assertThat(car.getPosition()).isEqualTo(1);
  }

  @DisplayName("자동차가 안움직이는 경우")
  @Test
  void not_move_test() {
    Car car = new Car(TEST_CAR, 0);
    car.move(() -> false);
    assertThat(car.getPosition()).isEqualTo(0);
  }

  @DisplayName("자동차 이름이 5보다 크면 예외 발생")
  @Test
  void name_length_over_five_throw_exception() {
    assertThatThrownBy(() -> new Car("TEST66", 0))
        .isInstanceOf(OverCarNameLengthException.class)
        .hasMessage("자동차 이름 길이가 5를 초과했습니다.");

  }

}
