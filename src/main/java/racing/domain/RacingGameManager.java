package racing.domain;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < racingCars.size(); i++) {
            randomNumbers.add(random.nextInt(RANDOM_MAX_NUMBER));
        }
        racingCars.moveCars(randomNumbers);

        ResultView.printCarsCurrentPosition(racingCars);
    }

}
