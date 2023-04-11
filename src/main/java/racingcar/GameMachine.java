package racingcar;

import java.util.stream.IntStream;
import racingcar.application.Cars;
import racingcar.application.RandomAccelerator;
import racingcar.application.RandomMoveStrategy;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class GameMachine {
  private final InputView inputView = new InputView();
  private final ResultView resultView = new ResultView();

  public static void main(String[] args) {
    GameMachine gameMachine = new GameMachine();
    gameMachine.play();
  }

  public void play() {
    int carNumber = inputView.askCarNumbers().carNumber();
    int trialNumber = inputView.askTrialNumbers().trialNumber();

    Cars cars = new Cars(new RandomMoveStrategy(new RandomAccelerator()), carNumber);

    resultView.printResultAlert();

    IntStream.rangeClosed(1, trialNumber)
        .forEach((number) -> {
          cars.go();
          resultView.printLocations(cars.locationValues());
        });
  }
}
