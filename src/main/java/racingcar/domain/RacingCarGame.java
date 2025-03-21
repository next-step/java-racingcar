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

    Cars lastRecords = null;
    for (int i = 0; i < rounds; i++) {
      lastRecords = racing.start(); // 각 라운드 실행 후 결과 저장
      ResultView.printResult(lastRecords);
    }
    if (lastRecords != null) {
      List<String> winners = cars.getWinners(lastRecords);
      ResultView.printWinner(winners);
    }
  }

}
