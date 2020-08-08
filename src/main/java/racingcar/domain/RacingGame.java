package racingcar.domain;

import racingcar.utils.ProductRandomGenerator;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingGame {

    public void run() {
        play();
    }

    public void play() {
        int carCountNumber = InputView.inputCarCount();
        int round = InputView.inputRoundNumber();

        ProductRandomGenerator randomValue = new ProductRandomGenerator();

        Cars cars = new Cars(carCountNumber);
        for (int i = 0; i < round; i++) {
            cars.moveCars(randomValue);
            ResultView.printResult(cars);
            System.out.println();
        }
    }
}
