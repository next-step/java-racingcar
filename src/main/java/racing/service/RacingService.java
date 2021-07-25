package racing.service;

import racing.domain.Racing;
import racing.utils.RacingUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    public boolean randomPlay() {
        int randomNumber = RacingUtils.randomNumber();
        return RacingUtils.compareNumbers(randomNumber);
    }

    public boolean[] race(int cars) {
        boolean[] racingResult = new boolean[cars];
        for (int i = 0; i < cars; i++) {
            racingResult[i] = randomPlay();
        }
        return racingResult;
    }

    public List<Racing> exec(int racingRound, int racingCar){

        RacingUtils.checkInputValue(racingRound, racingCar);
        List<Racing> racingList = new ArrayList<>();
        for (int i = 0; i < racingRound; i++) {
            Racing racing = new Racing(race(racingCar));
            racingList.add(i, racing);
        }
        return racingList;
    }
}
