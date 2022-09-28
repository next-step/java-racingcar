package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MovingStrategy;
import racingcar.domain.Car;

public class MovingStrategyTest {

  MovingStrategy movingStrategy = new MovingStrategy();

  @Test
  @DisplayName("랜덤값이 4 미만일 때")
  public void inputUnder4Num() {
    Car car = new Car();
    int randomInt = 2;
    String result = movingStrategy.moveCar(randomInt, car.positionView, car.criteriaNum);
    assertThat(result).isEmpty();
  }

  @Test
  @DisplayName("차량이 2회 이동할 때")
  public void moveTwoTimes() {
    Car car = new Car();
    int randomInt = 5;
    int randomInt2 = 6;
    car.positionView = movingStrategy.moveCar(randomInt, car.positionView, car.criteriaNum);
    car.positionView = movingStrategy.moveCar(randomInt2, car.positionView, car.criteriaNum);
    assertThat(car.positionView).isEqualTo("--");
  }

}
