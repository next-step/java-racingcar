package carrace;

import carrace.domain.RaceTrack;
import carrace.ui.InputView;
import carrace.ui.ResultView;

public class RaceApp {
    public static void main(String[] args) throws InterruptedException {
        int carCount = InputView.scanCarCount();
        int tryCount = InputView.scanTryCount();

        startRace(carCount, tryCount);
    }

    private static void startRace(int carCount, int tryCount) throws InterruptedException {
        RaceTrack raceTrack = new RaceTrack(carCount);

        ResultView.printResultTitle();
        ResultView.printResult(raceTrack);

        for (int i = 0; i < tryCount; i++) {
            Thread.sleep(1000);
            raceTrack.next();
            ResultView.printResult(raceTrack);
        }
    }
}
