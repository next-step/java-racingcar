package pobiRacingCar;

import pobiRacingCar.domain.RacingGame;
import pobiRacingCar.view.InputView;
import pobiRacingCar.view.ResultView;

public class RacingMain {
    public static void main(String[] args) {
        String carNames = InputView.getCarNames();
        int tryNo = InputView.getTryNo();

        RacingGame racingGame = new RacingGame(carNames, tryNo);
        while (racingGame.racing( )) {
            racingGame.race();
            ResultView.printCars(racingGame.getCars());
        }
        ResultView.printWinners(racingGame.getWinners());
    }
}
