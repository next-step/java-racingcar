package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MovingStrategy;
import racingcar.RandomMovingStrategy;
import racingcar.domain.Car;

public class MovingStrategyTest {

  @Test
  @DisplayName("랜덤값이 4 미만일 때")
  public void inputUnder4Num() {
    Car car = new Car();
    MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
    int randomInt = 2;
    int result = randomMovingStrategy.move(car, randomInt, car.getcriteriaNum());
    assertThat(result).isZero();
  }

  @Test
  @DisplayName("차량이 2회 이동할 때")
  public void moveTwoTimes() {
    Car car = new Car();
    MovingStrategy randomMovingStrategy = new RandomMovingStrategy();
    int randomInt = 5;
    int randomInt2 = 6;
    randomMovingStrategy.move(car, randomInt, car.getcriteriaNum());
    randomMovingStrategy.move(car, randomInt2, car.getcriteriaNum());
    assertThat(car.getPosition()).isEqualTo(2);
  }

}
