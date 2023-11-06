package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int moveCount = InputView.inputMoveCount();

        Cars cars = Cars.init(carNames);

        play(cars, moveCount);

        ResultView.printWinners(cars.winnerNames());
    }

    private static void play(Cars cars, int moveCount) {
        ResultView.printResultStart();

        for (int idx = 0; idx < moveCount; idx++) {
            List<String> results = cars.game();
            ResultView.printOneGameResult(results);
        }
    }
}
