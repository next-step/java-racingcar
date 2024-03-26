package racing;

import exception.CarLocationException;
import ui.ResultView;

import java.util.Set;

public class RacingService {

    public static void race(String carNames, Count tryCount) throws CarLocationException {
        RacingCars racingCars = new RacingCars(carNames);
        Set<RacingHistory> racingHistory = racingCars.startRace(tryCount);
        ResultView.showRaceResult(racingHistory);
        ResultView.showRaceWinner(racingCars);
    }

}
