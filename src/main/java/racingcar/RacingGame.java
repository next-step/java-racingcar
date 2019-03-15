package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int tryCnt;
    private List<RacingCar> racingCars;

    public RacingGame(List<RacingCar> racingCars, int tryCnt) {
        this.racingCars = racingCars;
        this.tryCnt = tryCnt;
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> getRacingCarNames() {
        List<String> carNames = new ArrayList<>();
        for (RacingCar car : racingCars) {
            carNames.add(car.getName());
        }
        return carNames;
    }
}
