package racing.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racing.strategy.MoveNumberStrategy;
import racing.strategy.StopNumberStrategy;

class CarTest {

  @Test
  void 자동차는멈출수있다() {
    Car car = new Car("stopCar", new StopNumberStrategy());
    car.move();

    assertThat(car.moveDistance()).isEqualTo(0);
  }

  @Test
  void 자동차는전진할수있다() {
    Car car = new Car("moveCar", new MoveNumberStrategy());
    car.move();

    assertThat(car.moveDistance()).isEqualTo(1);
  }

}