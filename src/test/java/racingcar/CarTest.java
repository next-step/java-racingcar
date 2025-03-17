package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

  @Test
  @DisplayName("자동차는 전진할 수 있다.")
  void move() {
    long id = 1;
    Car car = new Car(1);
    car.move();
    assertThat(car.getPosition()).isEqualTo(1);
  }

}
