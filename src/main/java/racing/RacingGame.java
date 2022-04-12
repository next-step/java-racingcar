package racing;

import java.util.ArrayList;
import java.util.List;
import racing.dto.RacingInput;
import racing.object.Car;
import racing.strategy.NumberCompareMoveStrategy;
import racing.strategy.RandomNumberGenerator;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingGame {

  public static void main(String[] args) {
    new RacingGame().start();
  }

  private void start() {
    RacingInput racingInput = getRacingInput();

    List<Car> cars = makeCars(racingInput);

    racing(cars, racingInput);

  }

  private RacingInput getRacingInput() {
    return new RacingInputView().printAndGetRacingInput();
  }

  private void racing(List<Car> cars, RacingInput racingInput) {
    RacingOutputView racingOutputView = new RacingOutputView();
    racingOutputView.printResultTitle();

    for (int i = 0; i < racingInput.getAttemptCount(); i++) {
      for (int j = 0; j < cars.size(); j++) {
        cars.get(j).attempt();
      }
      printResult(cars, racingOutputView);
    }
  }

  private void printResult(List<Car> cars, RacingOutputView racingOutputView) {
    racingOutputView.printCarDistance(cars);
  }

  private List<Car> makeCars(RacingInput racingInput) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < racingInput.getCarCount(); i++) {
      cars.add(new Car(new NumberCompareMoveStrategy(new RandomNumberGenerator())));
    }
    return cars;
  }

}
