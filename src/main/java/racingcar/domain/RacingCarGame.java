package racingcar.domain;

import java.util.List;
import racingcar.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
  public static void main(String[] args) {

    List<String> carNames = InputView.inputCarName();
    int rounds = InputView.inputRound();
    InputView.closeScanner();

    Cars cars = Cars.fromNames(carNames);
    Racing racing = new Racing(cars, new RandomNumberGenerator());

    for (int i = 0; i < rounds; i++) {
      ResultView.printResult(racing.start());
    }
    List<String> winners = cars.getWinners();
    ResultView.printWinner(winners);
  }

}
