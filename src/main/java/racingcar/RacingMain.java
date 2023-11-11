package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.Scanner;

public class RacingMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.carNameView();
        int tryCount = inputView.tryCountView();

        ResultView resultView = new ResultView();
        resultView.view();

        RacingGame racingGame = new RacingGame(carNames);
        for (int i = 0; i < tryCount; i++) {
            List<Car> cars = racingGame.race();
            resultView.viewGame(cars);
        }
        List<Car> winners = racingGame.findWinners();
        resultView.viewWinner(winners);
    }
}
