package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

  private Car car;

  @BeforeEach
  public void setup() {
    car = new Car("name");
  }

  @Test
  public void 조건값이상일때차가움직인다() {
    assertThat(car.move(Car.CONDITION_MOVE_NUMBER)).isEqualTo(1);
  }

  @Test
  public void 조건값이하면일차가움직이지않는다() {
    assertThat(car.move(Car.CONDITION_MOVE_NUMBER) - 1).isEqualTo(0);
  }

}
