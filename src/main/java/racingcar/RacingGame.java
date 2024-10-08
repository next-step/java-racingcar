package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarName();
        Cars cars = new Cars(carNames);
        Race race = new Race(cars);
        int racingCount = InputView.getRacingCount();

        ResultView resultView = new ResultView();
        resultView.printMessage();
        for (int i = 0; i < racingCount; i++) {
            race.run();
            resultView.printResult(cars);
        }
        resultView.printWinners(cars);
    }
}
