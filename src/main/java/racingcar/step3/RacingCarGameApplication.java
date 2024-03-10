package racingcar.step3;

import racingcar.step3.domain.Car;
import racingcar.step3.domain.RacingCarGame;
import racingcar.step3.domain.RacingCarGameResult;
import racingcar.step3.ui.InputValue;
import racingcar.step3.ui.InputView;
import racingcar.step3.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameApplication {

  public static void main(String[] args) {
    new RacingCarGameApplication().run(args);
  }

  public void run(String[] args) {
    InputValue input = InputView.receive();

    List<Car> cars = new ArrayList<>();
    for (int i = 1; i <= input.getNumberOfCars(); i++) {
      String carName = "car" + i;
      cars.add(new Car(carName));
    }

    RacingCarGame racingCarGame = new RacingCarGame(input.getTryCount(), cars);
    List<RacingCarGameResult> results = racingCarGame.start();
    ResultView.printResult(results);
  }
}
