package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.strategy.MovingStrategy;

public class CarTest {

  @Test
  void moveCarPosition() {
    MovingStrategy strategy = () -> true;

    Car car = new Car();
    car.move(strategy);

    assertThat(car.getCurrentPosition()).isEqualTo(1);
  }

  @Test
  void keepCarPosition() {
    MovingStrategy strategy = () -> false;

    Car car = new Car();
    car.move(strategy);

    assertThat(car.getCurrentPosition()).isEqualTo(0);
  }

}
