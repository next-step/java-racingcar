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
    int carNumbers = inputView.inputCarNumbers();
    int tryCount = inputView.inputTryCount();

    List<Car> cars = makeCars(carNumbers);

    outputView.printResult();
    for (int i = 0; i < tryCount; i++) {
      cars.forEach(car -> {
        car.move(new RandomMovable());
        outputView.printCarDistance(car.getDistance());
      });
      outputView.printEmptyLine();
    }
  }

  private List<Car> makeCars(int carNumbers) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < carNumbers; i++) {
      cars.add(new Car());
    }
    return cars;
  }

}
