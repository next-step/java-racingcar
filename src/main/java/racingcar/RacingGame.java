package racingcar;

import racingcar.domains.RacingCar;
import racingcar.domains.RacingResult;
import racingcar.utils.RandomNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public void initiateCars(List<RacingCar> racingCars, int carNumTotal) {
        for (int i = 0; i < carNumTotal; i++) {
            racingCars.add(new RacingCar());
        }
    }

    public List<RacingResult> startRace(List<RacingCar> racingCars, int roundNumTotal) {
        List<RacingResult> racingResult = new ArrayList<>();

        for (int i = 0; i < roundNumTotal; i++) {
            List<Integer> result = makeRandomMove(racingCars);
            racingResult.add(new RacingResult(result));
        }

        return racingResult;
    }

    private List<Integer> makeRandomMove(List<RacingCar> racingCars) {
        List<Integer> recordsForEachCar = new ArrayList<>();

        for (int j = 0; j < racingCars.size(); j++) {
            int randomNum = RandomNumberUtil.generateRandomNum();
            int currentPosition = racingCars.get(j).move(randomNum);
            recordsForEachCar.add(currentPosition);
        }

        return recordsForEachCar;
    }

}
