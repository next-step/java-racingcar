import racingcar.controller.RacingGame;
import racingcar.model.CarInformation;
import racingcar.model.CarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        List<CarName> carNames = InputView.inputCarNames();
        RacingGame racingGame = new RacingGame(carNames);

        int numberOfTries = InputView.inputNumberOfTries();
        OutputView.printResultMessage();

        for (int i = 0; i < numberOfTries; i++) {
            List<CarInformation> carsAfterRace = racingGame.raceOneStep();
            OutputView.printCars(carsAfterRace);
        }

        List<CarInformation> winners = racingGame.awards();
        OutputView.printWinners(winners);
    }
}
