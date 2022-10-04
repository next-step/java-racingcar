package racingCar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingCar.strategy.TestMovingStrategy;
import racingcar.domain.Car;
import racingcar.strategy.MovingStrategy;

public class CarTest {

  @Test
  @DisplayName("2회 이동 시 위치값이 2")
  void testcarPostion() {
    Car car = new Car("car1");
    MovingStrategy movingStrategy = new TestMovingStrategy();
    car.move(movingStrategy);
    car.move(movingStrategy);
    assertThat(car.getCarPosition()).isEqualTo(2);

  }
}
