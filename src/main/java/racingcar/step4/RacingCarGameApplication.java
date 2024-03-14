package racingcar.step4;

import racingcar.step4.domain.Car;
import racingcar.step4.domain.RacingCarGame;
import racingcar.step4.domain.factory.CarFactory;
import racingcar.step4.domain.factory.RacingCarGameFactory;
import racingcar.step4.presentaion.InputValue;
import racingcar.step4.presentaion.InputView;
import racingcar.step4.presentaion.ResultView;

import java.util.List;

public class RacingCarGameApplication {

  public static void main(String[] args) {
    new RacingCarGameApplication().run(args);
  }

  public void run(String[] args) {
    InputValue input = InputView.receive();
    List<Car> cars = CarFactory.of(input.getInputName());
    List<RacingCarGame> racingCarGames = RacingCarGameFactory.of(input.getTryCount(), cars);
    ResultView.printResult(racingCarGames);
    ResultView.printFinalWinners(racingCarGames);
  }
}
