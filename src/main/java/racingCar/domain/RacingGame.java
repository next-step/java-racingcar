package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import racingCar.view.OutputView;

public class RacingGame {

  private final String[] carNames;
  private final int tryCount;

  public RacingGame(String[] carNames, int tryCount) {
    this.carNames = carNames;
    this.tryCount = tryCount;
  }

  public List<Car> start(OutputView outputView) {
    List<Car> cars = makeCars(carNames);

    outputView.printResult();
    for (int i = 0; i < tryCount; i++) {
      cars.forEach(car -> {
        car.move(new RandomMovable());
        outputView.printCarDistance(car);
      });
      outputView.printEmptyLine();
    }

    return Referee.determineWinners(cars);
  }

  private List<Car> makeCars(String[] carNames) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < carNames.length; i++) {
      cars.add(new Car(carNames[i], 0));
    }
    return cars;
  }


}
