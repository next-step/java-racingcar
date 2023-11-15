package racing;

import racing.domain.racing.Racing;
import racing.domain.racing.RandomNumber;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Random;

public class RacingApp {

    public static void main(String[] args) {
        String inputNames = InputView.getInputNames();
        int attemptCount = InputView.getNumberOfAttempts();
        Racing racing = new Racing(inputNames);

        for (int i = 0; i < attemptCount; ++i) {
            round(racing);
            ResultView.showCurrentPosition(racing.participatingCars().cars());
        }

        ResultView.showWinners(racing.winners());
    }

    private static void round(Racing racing) {
        int[] randomNumbers = new int[racing.participatingCars().numberOfCars()];
        for (int i = 0; i < racing.participatingCars().numberOfCars(); ++i) {
            randomNumbers[i] = RandomNumber.randomNumberUnder10();
        }
        racing.race(randomNumbers);
    }
}
