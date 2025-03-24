package racingcar;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class MainApplication {

  public static void main(String[] args) {
    InputView inputView = new InputView();
    Names carNames = new Names(inputView.getCarNames());
    int roundCount = inputView.getRoundCount();

    RaceEvaluator raceEvaluator = new RaceEvaluator();

    Racer racer = new Racer(carNames, roundCount, raceEvaluator);
    Result result = racer.race();

    ResultView resultView = new ResultView();
    resultView.showResult(result);
  }
}
