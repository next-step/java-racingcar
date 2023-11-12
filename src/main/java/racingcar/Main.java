package racingcar;

import racingcar.domain.RacingSimulator;
import racingcar.view.ResultView;

import java.util.List;

import static racingcar.CarNameValidator.carNameValidation;
import static racingcar.WinnerFinder.findWinner;
import static racingcar.view.InputView.readCarName;
import static racingcar.view.InputView.readTryCount;
import static racingcar.view.ResultView.printCarsPosition;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = carNameValidation(readCarName());
        int tryCount = readTryCount();

        RacingSimulator racingSimulator = new RacingSimulator(carNames, tryCount);

        ResultView.printResult();

        while (!racingSimulator.isEnd()) {
            racingSimulator.simulate();
            printCarsPosition(racingSimulator.getRacingCars());
        }
        ResultView.printWinner(findWinner(racingSimulator.getRacingCars()));
    }
}
