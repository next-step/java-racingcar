package racing.domain;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGameManager {
    private static final Random random = new Random();
    private static final int RANDOM_MAX_NUMBER = 10;

    public void play() {
        Count carCount = new Count(InputView.askNumberOfCarParticipants());
        Count attemptCount = new Count(InputView.askNumberOfAttempt());
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carCount.value(); i++) {
            racingCars.add(new RacingCar());
        }

        ResultView.printGameResultTitle();
        for (int i = 0; i < attemptCount.value(); i++) {
            playRound(racingCars);
        }

    }

    private void playRound(List<RacingCar> racingCars) {
        racingCars.forEach(this::playCar);
        ResultView.printCarCurrentPosition(racingCars);
    }

    private void playCar(RacingCar racingCar) {
        racingCar.attemptToMove(random.nextInt(RANDOM_MAX_NUMBER));
    }
}
