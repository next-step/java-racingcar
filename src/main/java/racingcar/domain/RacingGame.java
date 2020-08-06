package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

    public void run() {
        play();
    }

    public void play() {
        int carCountNumber = InputView.inputCarCount();
        int round = InputView.inputRoundNumber();

        Cars cars = new Cars(carCountNumber);
        for (int i = 0; i < round; i++) {
            cars.moveCars();
            ResultView.printResult(cars.getCars());
            System.out.println();
        }
    }
}
