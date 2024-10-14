package racingcar;


import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.List;

public class GameApplication {

  public static void main(String[] args) {
    List<String> carNames = InputView.getCarNames();
    Cars cars = Cars.createCars(carNames);

    int tryCount = InputView.getTryCount();

    MoveStrategy moveStrategy = new RandomMoveStrategy();

    ResultView.printExecuteMessage();
    for (int i = 0; i < tryCount; i++) {
      cars.moveCars(moveStrategy);
      ResultView.print(cars);
    }
    ResultView.printWinnersName(cars);
  }
}
