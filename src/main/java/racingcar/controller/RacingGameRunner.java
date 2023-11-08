package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingGameRunner {

    public static void main(String[] args) {
        List<String> carNames = InputView.inputCarNames();
        int moveCount = InputView.inputMoveCount();

        Cars cars = Cars.creatCarsByNames(carNames);

        play(cars, moveCount);

        ResultView.printWinners(cars);
    }

    private static void play(Cars cars, int moveCount) {
        ResultView.printResultStart();

        for (int idx = 0; idx < moveCount; idx++) {
            cars.game();
            ResultView.printResult(cars);
        }
    }
}
