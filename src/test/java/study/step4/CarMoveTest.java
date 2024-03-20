package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step4.domain.Car;
import racingcar.step4.domain.strategy.RandomCarMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.step4.domain.Position.DEFAULT_START_POSITION;

public class CarMoveTest {

  @Test
  @DisplayName("isMovable()이 true인 경우, 자동차 전진 테스트")
  void carMoveTest() {
    Car car = new Car("car1", new RandomCarMoveStrategy());
    car.move(bound -> 5);
    assertThat(car.getPosition()).isEqualTo(DEFAULT_START_POSITION + 1);
  }

  @Test
  @DisplayName("isMovable()이 false 경우, 자동차가 전진하지 않는 경우 테스트")
  void carStopTest() {
    Car car = new Car("car1", new RandomCarMoveStrategy());
    car.move(bound -> 1);
    assertThat(car.getPosition()).isEqualTo(DEFAULT_START_POSITION);
  }
}
