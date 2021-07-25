package racing.service;

import racing.domain.Racing;
import racing.utils.RacingUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    public boolean randomPlay() {
        int randomNumber = RacingUtils.randomNumber();
        RacingUtils.checkRandomNumber(randomNumber);
        return RacingUtils.compareNumbers(randomNumber);
    }

    public boolean[] race(int cars) {
        boolean[] racingDetailResult = new boolean[cars];
        for (int i = 0; i < cars; i++) {
            racingDetailResult[i] = randomPlay();
        }
        return racingDetailResult;
    }

    public List<Racing> exec(int racingRound, int racingCar){

        RacingUtils.checkInputValue(racingRound, racingCar);
        List<Racing> racingResultList = new ArrayList<>();
        for (int i = 0; i < racingRound; i++) {
            Racing racingResult = new Racing(race(racingCar));
            racingResultList.add(i, racingResult);
        }
        return racingResultList;
    }
}
