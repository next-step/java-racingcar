package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(String[] carNames) {
        this.racingCars = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            this.racingCars.add(new RacingCar(carNames[i]));
        }
    }

    public void runRacingRound(MoveStrategy moveStrategy) {
        for (RacingCar racingCar : this.racingCars) {
            racingCar.tryToMove(moveStrategy);
        }
    }

    // 자동차들 객체 가져오기
    public List<RacingCar> statusOfRacingCars() {
        return this.racingCars;
    }

}
