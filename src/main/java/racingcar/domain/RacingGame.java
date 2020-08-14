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
        CarMove carMove = new CarMove();
        for (int i = 0; i < round; i++) {
            cars.moveCars(carMove);
            ResultView.printResult(cars);
        }
        ResultView.printWinner(cars.winnerIs(cars));
    }
}
