package racingcar;

import java.util.List;
import racingcar.domain.Car;

public class RacingRule {

  public static void cycleTryTimes(int tryTimes, List<Car> cars) {
    for (int i = 0; i < tryTimes; i++) {
      cycleCarMove(cars);
      System.out.println();
    }
  }

  private static void cycleCarMove(List<Car> cars) {

    RandomNum randomNum = new RandomNum();
    MovingStrategy movingStrategy = new MovingStrategy();

    for (Car car : cars) {
      int randNum = randomNum.createRandNum();
      car.positionView = movingStrategy.moveCar(randNum, car.positionView, car.criteriaNum);
      System.out.println(car.positionView);
    }
  }

}
