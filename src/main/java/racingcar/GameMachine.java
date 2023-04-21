package racingcar;

import java.util.stream.IntStream;
import racingcar.application.Cars;
import racingcar.application.RandomAccelerator;
import racingcar.application.RandomMoveStrategy;
import racingcar.dto.CarNames;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class GameMachine {
  private final InputView inputView = new InputView();
  private final ResultView resultView = new ResultView();

  public void play() {
    CarNames carNames = inputView.askCarNames();
    int trialNumber = inputView.askTrialNumbers().trialNumber();

    Cars cars = Cars.readyForRace(new RandomMoveStrategy(new RandomAccelerator()), carNames);

    resultView.printResultAlert();

    IntStream.rangeClosed(1, trialNumber)
        .forEach((number) -> {
          cars.go();
          resultView.printLocations(cars);
        });

    resultView.printWinner(cars.winnerName());
  }
}
