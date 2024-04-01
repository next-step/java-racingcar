package racing.service;

import exception.CarLocationException;
import racing.domain.Count;
import racing.domain.RacingCars;
import racing.domain.RacingHistory;
import racing.view.ResultView;

import java.util.Set;

public class RacingService {

    public static void race(String carNames, Count tryCount) throws CarLocationException {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RacingCars racingCars = new RacingCars(carNames);
        Set<RacingHistory> racingHistory = racingCars.startRace(tryCount, numberGenerator);
        ResultView.showRaceResult(racingHistory);
        ResultView.showRaceWinner(racingCars);
    }

}
