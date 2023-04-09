package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

  @Test
  @DisplayName("4 이상의 값이 들어오면 전진한다")
  void goTest() {
    // given
    Car car = new Car(() -> 4);
    int beforeLocation = car.location();

    // when
    car.go();

    // then
    Assertions.assertThat(beforeLocation + 1).isEqualTo(car.location());
  }

  @Test
  @DisplayName("3 이하의 값이 들어오면 정지한다")
  void goFailTest() {
    // given
    Car car = new Car(() -> 3);
    int beforeLocation = car.location();

    // when
    car.go();

    // then
    Assertions.assertThat(beforeLocation).isEqualTo(car.location());
  }
}
