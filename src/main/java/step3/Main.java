package step3;

import step3.domain.RacingCar;
import step3.domain.RacingGame;
import step3.domain.RandomNumberGenerator;
import step3.view.InputView;
import step3.view.ResultView;

public class Main {

    public static void main(String[] args) {
        String[] carNames = InputView.askCarNames();
        int attemptCount = InputView.askNumberOfAttempts();

        RacingCar[] racingCars = new RacingCar[carNames.length];
        for (int idx = 0; idx < carNames.length; idx++) {
            racingCars[idx] = new RacingCar(carNames[idx]);
        }

        ResultView.title();
        RacingGame racingGame = new RacingGame(racingCars, new RandomNumberGenerator());
        for (int attempt = 0; attempt < attemptCount; attempt++) {
            RacingCar[] racingCar = racingGame.runRound();
            ResultView.printRacingCarsStatus(racingCar);
        }
    }

}
