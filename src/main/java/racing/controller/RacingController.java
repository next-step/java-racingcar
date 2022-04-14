package racing.controller;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.strategy.NumberCompareMoveStrategy;
import racing.domain.strategy.RandomNumberGenerator;
import racing.view.RacingInputView;
import racing.view.RacingOutputView;

public class RacingController {

  public void startGame() {
    RacingInputView racingInputView = new RacingInputView();
    racingInputView.setRacingUserInput();

    RacingOutputView racingOutputView = new RacingOutputView();
    racingOutputView.printResultTitle();

    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < racingInputView.getCarCount(); i++) {
      carList.add(new Car(new NumberCompareMoveStrategy(new RandomNumberGenerator())));
    }
    Cars cars = new Cars(carList);

    for (int i = 0; i < racingInputView.getCarCount(); i++) {
      cars.attempt();
      racingOutputView.printCarDistance(cars);
    }
  }

}
