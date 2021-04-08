package racingcar.domains;

import racingcar.strategies.RandomMoveStrategy;
import racingcar.utils.RandomNumberUtil;

import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public int size() {
        return racingCars.size();
    }

    public int move(int carNum) {
        return racingCars.get(carNum).move(new RandomMoveStrategy());
    }

}
