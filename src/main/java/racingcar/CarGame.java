package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Winner;
import racingcar.util.DefaultNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarGame {
    public static void main(String[] args) {
        String names = InputView.carName();
        int round = InputView.round();

        Cars cars = new Cars(names);

        OutputView.endMessage();
        for (int i = 0; i < round; i++) {
            cars.race(new DefaultNumberGenerator());
            OutputView.gameResult(cars);
        }

        Winner winner = new Winner(cars);
        OutputView.gameWinner(winner);
    }
}
