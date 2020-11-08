package racing;

import racing.domain.RaceResult;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingArena {
    public static void main(String[] args) {
        String names = InputView.getInputNames();
        int maxCheckPoint = InputView.getMaxCheckPoint();

        CarRacing carRacing = new CarRacing(names,maxCheckPoint);
        carRacing.start();

        RaceResult raceResult = carRacing.getRaceResults();

        ResultView.viewRaceResult(raceResult);
        ResultView.viewRaceWinners(raceResult);
    }
}
