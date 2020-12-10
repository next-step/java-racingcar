package carrace;

import carrace.domain.RaceTrack;
import carrace.domain.RandomRacingRule;
import carrace.ui.InputView;
import carrace.ui.ResultView;

public class RaceApp {
    public static void main(String[] args) throws InterruptedException {
//        int carCount = InputView.scanCarCount();
        String[] carNames = InputView.scanCarName();
        int tryCount = InputView.scanTryCount();

        startRace(carNames, tryCount);
    }

    private static void startRace(int carCount, int tryCount) throws InterruptedException {
        RaceTrack raceTrack = new RaceTrack(new RandomRacingRule(), carCount);

        ResultView.printResultTitle();
        ResultView.printResult(raceTrack);

        for (int i = 0; i < tryCount; i++) {
            Thread.sleep(1000);
            raceTrack.next();
            ResultView.printResult(raceTrack);
        }
    }

    private static void startRace(String[] carNames, int tryCount) throws InterruptedException {
        RaceTrack raceTrack = new RaceTrack(new RandomRacingRule(), carNames);

        ResultView.printResultTitle();
        ResultView.printResult(raceTrack);

        for (int i = 0; i < tryCount; i++) {
            Thread.sleep(1000);
            raceTrack.next();
            ResultView.printResult(raceTrack);
        }
    }
}
