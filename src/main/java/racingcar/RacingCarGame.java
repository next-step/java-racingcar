package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.random.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingCarGame {
  public static void main(String[] args) {

    List<String> carNames = InputView.inputCarName();
    int rounds = InputView.inputRound();
    InputView.closeScanner();

    Cars cars = new Cars(
        carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList())
    );

    Racing racing = new Racing(cars, new RandomNumberGenerator());

    Cars lastRecords = null;
    for (int i = 0; i < rounds; i++) {
      lastRecords = racing.start(); // 각 라운드 실행 후 결과 저장
      ResultView.printResult(lastRecords);
    }
    if (lastRecords != null) {
      List<String> winners = RacingWinnerDeterminer.getWinner(lastRecords);
      ResultView.printWinner(winners);
    }
  }

}
