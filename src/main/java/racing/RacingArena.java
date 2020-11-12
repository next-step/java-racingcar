package racing;

import racing.domain.RaceRound;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingArena {
    public static void main(String[] args) {
        String names = InputView.getInputNames();
        int maxCheckPoint = InputView.getMaxCheckPoint();

        RacingController controller = new RacingController(names, maxCheckPoint);
        controller.execute();

        RaceRound raceRound = controller.getRacingRound();
        ResultView.viewRaceResult(raceRound);
        ResultView.viewRaceWinners(raceRound);
    }
}
