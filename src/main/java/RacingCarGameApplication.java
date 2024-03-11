import java.util.List;
import racingcar.Car;
import racingcar.InputView;
import racingcar.RacingCarGame;
import racingcar.ResultView;

public class RacingCarGameApplication {

  public static void main(String[] args) {

    InputView inputView = new InputView();
    int carCount = inputView.inputCarCount();
    int tryCount = inputView.inputTryCount();


    ResultView resultView = new ResultView();
    RacingCarGame racingCarGame = new RacingCarGame();
    racingCarGame.createCars(carCount);
    for (int i = 0; i < tryCount; i++) {
      List<Car> racingCar = racingCarGame.racing(carCount);
      resultView.printGameResult(racingCar);
    }
  }
}
