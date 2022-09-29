package racingcar;

import java.util.List;
import racingcar.domain.Car;

public class RacingRule {

  public void play(int trynum, List<Car> cars) {
    for (int i = 0; i < trynum; i++) {
      System.out.println("실행 결과");
      ResultView resultView = new ResultView();
      resultView.printResult(cycleCarMove(cars));
    }
  }

  private static List<Car> cycleCarMove(List<Car> cars) {

    for (Car car : cars) {
      RandomMovingStrategy randomMovingStrategy = new RandomMovingStrategy();
      randomMovingStrategy.move(car, randomMovingStrategy.getRandNum(),
          car.getcriteriaNum());
    }
    return cars;
  }


}
