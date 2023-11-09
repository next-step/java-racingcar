package carRacing;

import static carRacing.InputView.*;
import static carRacing.ResultView.*;

public class RacingGameApplication {
    private static final NumberGenerator RANDOM_NUMBER_GENERATOR = new RandomNumberGenerator();
    private static final MovingStrategy MOVING_STRATEGY = new GreaterThanThreeMovingStrategy();

    public static void main(String[] args) {

        String[] nameArray = readCarList();
        int raceCount = readRaceCount();
        RacingProcess racingProcess = new RacingProcess(nameArray, MOVING_STRATEGY);

        resultTitle();
        startRacingGame(racingProcess, raceCount);
        printRacingWinner(racingProcess.callCarRacingWinners());


    }

    private static void startRacingGame(RacingProcess racingProcess, int raceCount) {

        for (int i = 0; i < raceCount; i++) {
            racingProcess.roundPlay(RANDOM_NUMBER_GENERATOR);
            ResultView.printRoundResult(racingProcess.getCarsStatus());
        }
        racingProcess.callCarRacingWinners();

    }
}
