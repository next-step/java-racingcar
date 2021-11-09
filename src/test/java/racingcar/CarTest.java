package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.strategy.MovingStrategy;

public class CarTest {

  @Test
  @DisplayName("자동차가 움직이는 조건인 경우, 자동차 위치 변경 확인")
  void movableCarPosition() {
    MovingStrategy strategy = () -> true;

    Car car = new Car();
    car.move(strategy);

    assertThat(car.getCurrentPosition()).isEqualTo(1);
  }

  @Test
  @DisplayName("자동차가 움직이지 않는 조건인 경우, 자동차 위치 유지 확인")
  void immovableCarPosition() {
    MovingStrategy strategy = () -> false;

    Car car = new Car();
    car.move(strategy);

    assertThat(car.getCurrentPosition()).isEqualTo(0);
  }

}
