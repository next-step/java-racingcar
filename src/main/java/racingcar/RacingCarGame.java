package racingcar;

import java.util.List;
import racingcar.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
    public static void main(String[] args) {

      int carCount = InputView.inputCarCount();
      int round = InputView.inputRound();
      InputView.closeScanner();

      Racing racing = new Racing(carCount, new RandomNumberGenerator());

      for (int i = 0; i < round; i++) {
        ResultView.printResult(racing.start());
      }
    }

}
