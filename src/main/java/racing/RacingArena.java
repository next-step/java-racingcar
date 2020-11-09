package racing;

import racing.domain.RaceRound;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingArena {
    public static void main(String[] args) {
        String names = InputView.getInputNames();
        int maxCheckPoint = InputView.getMaxCheckPoint();

        CarRacing carRacing = new CarRacing(names,maxCheckPoint);
        carRacing.start();

        RaceRound raceRound = carRacing.getRaceRound();
        ResultView.viewRaceResult(raceRound);
        ResultView.viewRaceWinners(raceRound);
    }
}
