package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
    public static void main(String[] args) {

      List<String> carNames = InputView.inputCarName();
      int rounds = InputView.inputRound();
      InputView.closeScanner();

      Racing racing = new Racing(carNames, new RandomNumberGenerator());
      List<Car> lastRecords = new ArrayList<>();

      for (int now = 0; now < rounds; now++) {
        lastRecords = racing.start();
        ResultView.printResult(lastRecords);
      }

      List<String> winners = RacingWinnerDeterminer.getWinner(lastRecords);
      ResultView.printWinner(winners);
    }

}
