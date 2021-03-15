package racingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

  private InputView inputView;
  private OutputView outputView;

  public RacingGame(InputView inputView, OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
  }

  public void start() {
    String[] carNames = inputView.inputCarNames();
    int tryCount = inputView.inputTryCount();

    List<Car> cars = makeCars(carNames);

    outputView.printResult();
    for (int i = 0; i < tryCount; i++) {
      cars.forEach(car -> {
        car.move(new RandomMovable());
        outputView.printCarDistance(car);
      });
      outputView.printEmptyLine();
    }
  }

  private List<Car> makeCars(String[] carNames) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < carNames.length; i++) {
      cars.add(new Car(carNames[i]));
    }
    return cars;
  }

}
