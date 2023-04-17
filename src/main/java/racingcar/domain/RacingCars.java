package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(int numberOfCars) {
        this.racingCars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            this.racingCars.add(new RacingCar());
        }
    }

    public void tryToRacingRound(MoveStrategy moveStrategy) {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.tryToMove(moveStrategy);
        }
    }

    // 자동차들 객체 가져오기
    public List<RacingCar> statusOfRacingCars() {
        return racingCars;
    }

}
