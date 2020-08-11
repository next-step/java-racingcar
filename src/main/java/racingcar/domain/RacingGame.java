package racingcar.domain;

import racingcar.utils.CarMove;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

    public void run() {
        play();
    }

    public void play() {
        String[] carNames = InputView.inputCarName();
        int round = InputView.inputRoundNumber();

        Cars cars = new Cars(carNames);
        for (int i = 0; i < round; i++) {
            cars.moveCars(new CarMove());
            ResultView.printResult(cars);
        }
        ResultView.printWinner(cars.winnerIs(cars));
    }
}
