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
        CarCount carCount = new CarCount(InputView.askNumberOfCarParticipants());
        AttemptCount attemptCount = new AttemptCount(InputView.askNumberOfAttempt());
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carCount.getNumberOfRacingCar(); i++) {
            racingCars.add(new RacingCar());
        }

        ResultView.printGameResultTitle();
        for (int i = 0; i < attemptCount.getNumberOfAttempt(); i++) {
            playRound(racingCars);
        }

    }

    private void playRound(List<RacingCar> racingCars) {
        racingCars.forEach(this::playCar);
        ResultView.printCarCurrentPosition(racingCars);
    }

    private void playCar(RacingCar racingCar) {
        racingCar.attempToMove(random.nextInt(RANDOM_MAX_NUMBER));
    }
}
