package racingcar.application;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.carNames();
        int tryNum = InputView.tryTime();

        RacingGame racingGame = new RacingGame(carNames);

        RacingCars racingCars = racingGame.getRacingCars();
        ResultView.results(racingGame.startRace(tryNum));

        ResultView.whoIsWinner(racingCars.whoIsWinners());
    }
}
