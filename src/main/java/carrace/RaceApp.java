package carrace;

import carrace.domain.RaceTrack;
import carrace.domain.RandomRacingRule;
import carrace.view.input.InputView;
import carrace.view.ResultView;

public class RaceApp {
    public static void main(String[] args) throws InterruptedException {
        String[] carNames = InputView.scanCarName();
        int tryCount = InputView.scanTryCount();

        startRace(carNames, tryCount);
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

        ResultView.printWinner(raceTrack);
    }
}
