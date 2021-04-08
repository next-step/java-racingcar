package racingcar;

import racingcar.domains.RacingCar;
import racingcar.domains.RacingCars;
import racingcar.domains.RacingResult;
import racingcar.utils.RandomNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> racingCars;

    public RacingGame() {
        this.racingCars = new ArrayList<>();
    }

    public RacingCars initiateCars(int carNumTotal) {
        for (int i = 0; i < carNumTotal; i++) {
            racingCars.add(new RacingCar());
        }
        return new RacingCars(racingCars);
    }

    public List<RacingResult> startRace(RacingCars racingCars, int roundNumTotal) {
        List<RacingResult> racingResult = new ArrayList<>();

        for (int i = 0; i < roundNumTotal; i++) {
            List<Integer> result = makeRandomMove(racingCars);
            racingResult.add(new RacingResult(result));
        }

        return racingResult;
    }

    private List<Integer> makeRandomMove(RacingCars racingCars) {
        List<Integer> recordsForEachCar = new ArrayList<>();

        for (int j = 0; j < racingCars.size(); j++) {
            int currentPosition = racingCars.move(j);
            recordsForEachCar.add(currentPosition);
        }

        return recordsForEachCar;
    }

}
