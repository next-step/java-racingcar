package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class MainSimulator {

    public static void main(String[] args) {

        String names = InputView.getCarNames();
        int racingCount = InputView.getRacingCount();

        RacingGame racingGame = new RacingGame(names, racingCount);
        List<Cars> records = racingGame.start();

        ResultView.printResult(records);

        Cars winners = racingGame.getWinners(records);
        ResultView.printWinners(winners);

    }

}
