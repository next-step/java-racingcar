package step3;

import step3.domain.RacingCar;
import step3.domain.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int carCount = InputView.askNumberOfCars();
        int attemptCount = InputView.askNumberOfAttempts();

        ResultView.title();
        RacingGame racingGame = new RacingGame(carCount);
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            RacingCar[] racingCar = racingGame.runRound();
            ResultView.printRacingCarsStatus(racingCar);
        }
    }

}
