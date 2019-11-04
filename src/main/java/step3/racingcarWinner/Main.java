package step3.racingcarWinner;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    RacingGame racingGame = new RacingGame(inputView.carNames(),inputView.racingLap());
    List<Car> carList = racingGame.start();
    ResultView resultView = new ResultView(racingGame);
    resultView.printFinalWinner(carList);
  }
}
