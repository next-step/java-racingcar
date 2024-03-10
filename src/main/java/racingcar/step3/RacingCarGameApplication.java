package racingcar.step3;

import racingcar.step3.domain.Car;
import racingcar.step3.domain.CarFactory;
import racingcar.step3.domain.RacingCarGame;
import racingcar.step3.domain.RacingCarGameResult;
import racingcar.step3.ui.InputValue;
import racingcar.step3.ui.InputView;
import racingcar.step3.ui.ResultView;

import java.util.List;

public class RacingCarGameApplication {

  public static void main(String[] args) {
    new RacingCarGameApplication().run(args);
  }

  public void run(String[] args) {
    InputValue input = InputView.receive();

    List<Car> cars = CarFactory.of(input.getNumberOfCars());
    RacingCarGame racingCarGame = new RacingCarGame(input.getTryCount(), cars);
    List<RacingCarGameResult> results = racingCarGame.start();
    ResultView.printResult(results);
  }
}
