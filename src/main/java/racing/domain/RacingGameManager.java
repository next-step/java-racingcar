package racing.domain;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.Random;

public class RacingGameManager {
    private static final Random random = new Random();
    private static final int RANDOM_MAX_NUMBER = 10;

    public void play() {
        RacingCars racingCars = new RacingCars(InputView.askNumberOfCarParticipants());
        Count attemptCount = new Count(InputView.askNumberOfAttempt());

        ResultView.printGameResultTitle();
        for (int i = 0; i < attemptCount.value(); i++) {
            playRound(racingCars);
        }

        ResultView.printWinners(racingCars);
    }

    private void playRound(RacingCars racingCars) {
        racingCars.getRacingCarList().forEach(this::playCar);
        ResultView.printCarsCurrentPosition(racingCars);
    }

    private void playCar(RacingCar racingCar) {
        racingCar.attemptToMove(random.nextInt(RANDOM_MAX_NUMBER));
    }
}
