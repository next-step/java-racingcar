package carrace;

import carrace.domain.CarName;
import carrace.domain.RaceTrack;
import carrace.domain.RandomRacingRule;
import carrace.view.input.InputView;
import carrace.view.ResultView;

import java.util.List;

public class RaceApp {
    public static void main(String[] args) throws InterruptedException {
        List<CarName> carNames = InputView.scanCarName();
        int tryCount = InputView.scanTryCount();

        startRace(carNames, tryCount);
    }

    private static void startRace(List<CarName> carNames, int tryCount) throws InterruptedException {
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
