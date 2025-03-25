package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class MainApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    Names carNames = new Names(inputView.readCarNames());
    int roundCount = inputView.readRoundCount();

    RaceEvaluator raceEvaluator = new RaceEvaluator();

    Racer racer = new Racer(carNames, roundCount, raceEvaluator);
    Result result = racer.race();

    ResultView resultView = new ResultView();
    resultView.showResult(carNames, result);

    List<Car> winners = new Winner(result).getWinners();
    resultView.showWinners(winners);
  }
}
