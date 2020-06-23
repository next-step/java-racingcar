package racingcar.application;

import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
//        String carNames = InputView.carNames();
//        int tryNum = InputView.tryTime();

//        RacingGame racingGame = new RacingGame(carNames, tryNum);
        RacingGame racingGame = new RacingGame("1,2,3", 2);

        RacingCars racingCars = racingGame.getRacingCars();
        ResultView.results(racingCars.getNames(), racingGame.startRace());

        ResultView.whoIsWinner(racingCars.whoIsWinners());
    }
}
