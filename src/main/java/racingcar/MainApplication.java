package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Names;
import racingcar.domain.RaceEvaluator;
import racingcar.domain.Racer;
import racingcar.domain.Result;
import racingcar.domain.Winner;
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
