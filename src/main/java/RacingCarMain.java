import racingcar.controller.RacingGame;
import racingcar.model.CarInformation;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        RacingGame racingGame = new RacingGame(carNames);

        int numberOfTries = InputView.inputNumberOfTries();
        OutputView.printResultMessage();

        List<CarInformation> carsAfterRace = null;
        for (int i = 0; i < numberOfTries; i++) {
            carsAfterRace = racingGame.raceOneStep();
            OutputView.printCars(carsAfterRace);
        }

        List<CarInformation> winners = racingGame.awards(carsAfterRace);
        OutputView.printWinners(winners);
    }
}
