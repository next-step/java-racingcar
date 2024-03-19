package racing;

import exception.CarLocationException;
import ui.ResultView;

public class RacingService {

    public static void race(int carCount, int tryCount) throws CarLocationException {
        RacingCars racingCars = new RacingCars(carCount);
        for (int i = 0; i < tryCount; i++) {
            racingCars.startRace();
            ResultView.showRaceResult(racingCars, i);
        }
    }

}
