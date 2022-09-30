package racingcar;

import java.util.Random;
import racingcar.domain.Car;

public class RandomMovingStrategy implements MovingStrategy {

  private static final Random random = new Random();

  @Override
  public int getRandNum() {
    return random.nextInt(10);
  }

  @Override
  public int move(Car car, int randomInt, int criteriaNum) {
    if (isMoveAble(randomInt, criteriaNum)) {
      car.go();
    }
    return car.getPosition();
  }

  private boolean isMoveAble(int randomInt, int criteriaNum) {
    return randomInt >= criteriaNum;
  }

}
