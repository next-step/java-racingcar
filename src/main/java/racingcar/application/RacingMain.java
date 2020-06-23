package racingcar.application;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
//        String carNames = InputView.carNames();
//        int tryNum = InputView.tryTime();

//        RacingGame racingGame = new RacingGame(carNames, tryNum);
        RacingGame racingGame = new RacingGame("1,2,3");

        RacingCars racingCars = racingGame.getRacingCars();
        ResultView.results(racingGame.startRace(2));

        ResultView.whoIsWinner(racingCars.whoIsWinners());
    }
}
