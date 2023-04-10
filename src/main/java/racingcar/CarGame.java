package racingcar;

import racingcar.domain.Cars;
import racingcar.util.DefaultNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarGame {
    public static void main(String[] args) {
        int count = InputView.carCount();
        int round = InputView.round();

        Cars cars = new Cars(count);

        OutputView.endMessage();
        for (int i = 0; i < round; i++) {
            cars.race(new DefaultNumberGenerator());
            OutputView.gameResult(cars.positions());
        }
    }
}
