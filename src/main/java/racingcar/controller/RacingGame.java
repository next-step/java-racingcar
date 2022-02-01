package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.TryCount;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private static final String GAME_RESULT_MESSAGE = "출력결과";

    private List<Car> raceResult;

    public void play() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String[] carNames = inputView.inputCarNames();
        Cars cars = new Cars(carNames);
        TryCount tryCount = new TryCount(inputView.inputTryCount());

        System.out.println(GAME_RESULT_MESSAGE);
        int moveCount = 0;
        while (tryCount.isUnderTryCount(moveCount)) {
            raceResult = cars.moveForwardByCarsSize();
            outputView.printResult(raceResult);
            moveCount++;
        }

        Winner winner = new Winner(raceResult);
        outputView.printWinner(winner.findWinner());
    }

}
