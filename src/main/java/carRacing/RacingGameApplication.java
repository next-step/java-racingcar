package carRacing;

import static carRacing.InputView.*;
import static carRacing.ResultView.*;

public class RacingGameApplication {

    public static final NumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();
    public static final MovingStrategy MOVING_STRATEGY = new GreaterThanThreeMovingStrategy();

    public static void main(String[] args) {

        int carCount = readCarCount();
        int raceCount = readRaceCount();

        resultTitle();

        startRacingGame(carCount, raceCount);


    }

    private static void startRacingGame(int carCount, int raceCount) {

        RacingProcess racingProcess = new RacingProcess(carCount, MOVING_STRATEGY);

        for (int i = 0; i < raceCount; i++) {
            racingProcess.roundPlay(RANDOM_NUMBER_GENERATOR);
            ResultView.printRoundResult(racingProcess.getCarsDistance());
        }
    }
}
