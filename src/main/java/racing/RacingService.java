package racing;

import exception.CarLocationException;
import ui.ResultView;

public class RacingService {

    public static void race(Count carCount, Count tryCount) throws CarLocationException {
        RacingCars racingCars = new RacingCars(carCount.getValue());
        for (int i = 0; i < tryCount.getValue(); i++) {
            racingCars.startRace();
            ResultView.showRaceResult(racingCars, i);
        }
    }

}
