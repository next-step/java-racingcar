package study.racing;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Racing {

  public static void main(String[] args) {
    String[] carNames = InputView.getCarNames();
    Cars cars = createCars(carNames);
    int tryCount = InputView.getTryCount();
    printPosition(cars, tryCount);
    List<String> winnerNames = cars.getWinnerNames();
    printWinner(winnerNames);
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
      ResultView.printPosition(cars);
    }
  }

  private static void printWinner(List<String> winnerNames) {
    ResultView.printWinner(winnerNames);
  }

}
