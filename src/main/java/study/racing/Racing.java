package study.racing;

import java.util.List;
import study.racing.domain.Car;
import study.racing.domain.Cars;
import study.racing.domain.NumberConditionMoveStrategy;
import study.racing.view.InputView;
import study.racing.view.ResultView;

public class Racing {

  public static void main(String[] args) {
    String[] carNames = InputView.getCarNames();
    Cars cars = createCars(carNames);

    int tryCount = InputView.getTryCount();
    moveCars(cars, tryCount);

    List<String> winnerNames = cars.getWinnerNames();
    printWinner(winnerNames);
  }

  private static void moveCars(Cars cars, int tryCount) {
    for (int i = 0; i < tryCount; i++) {
      cars.moveByStrategy(new NumberConditionMoveStrategy());
      ResultView.printPositions(cars.getCarListForPrint());
    }
  }

  public static Cars createCars(String[] names) {
    Cars cars = new Cars();
    for (String name : names) {
      cars.addAll(new Car(name));
    }
    return cars;
  }

  private static void printPosition(Cars cars, int tryCount) {
    NumberConditionMoveStrategy strategy = new NumberConditionMoveStrategy();
    for (int i = 0; i < tryCount; i++) {
      cars.moveByStrategy(strategy);
    }
  }

  private static void printWinner(List<String> winnerNames) {
    ResultView.printWinner(winnerNames);
  }

}
