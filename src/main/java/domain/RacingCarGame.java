package domain;

import view.InputView;
import view.ResultView;

import java.util.Scanner;

public class RacingCarGame {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        InputView.carCount();
        final String cars = scanner.next();
        final RacingCars racingCars = RacingCars.from(cars);
        InputView.playCount();
        final String attempt = scanner.next();
        final RacingAttempt racingAttempt = RacingAttempt.from(attempt);
        ResultView.resultTitle();
        gamePlay(racingAttempt, racingCars);
    }

    private static void gamePlay(final RacingAttempt racingAttempt, final RacingCars racingCars) {

        final RacingScore racingScore = RacingScore.getInstance();
        raceStart(racingAttempt, racingCars, racingScore);
        ResultView.resultPrint(racingScore);
    }

    private static void raceStart(final RacingAttempt racingAttempt, final RacingCars racingCars, final RacingScore racingScore) {

        while (racingAttempt.isAttempt()) {
            racingAttempt.nextPlay(racingCars);
            racingScore.save(racingCars);
        }
    }
}
