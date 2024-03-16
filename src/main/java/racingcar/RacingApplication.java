package racingcar;

import java.util.ArrayList;
import java.util.List;

import common.NumberGenerator;
import common.RandomNumberGenerator;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.domain.RacingGame;
import racingcar.domain.Vehicle;
import racingcar.domain.Vehicles;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String[] carNames = inputView.getCarNames();
        Vehicles vehicles = new Vehicles(carNames);

        int round = inputView.getRound();
        Game game = new RacingGame(vehicles);
        ResultView resultView = new ResultView();
        for (int i = 0; i < round; i++) {
            game.start();
            resultView.printResult(vehicles);
        }
        resultView.printWinners(vehicles);
    }

}
