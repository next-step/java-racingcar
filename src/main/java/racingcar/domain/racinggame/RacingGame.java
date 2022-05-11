package racingcar.domain.racinggame;

import racingcar.domain.car.Cars;
import racingcar.domain.policy.MovePolicy;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final MovePolicy policy;
    private final Cars cars;
    private final TryNumber tryNumber;

    public RacingGame(String carNames, int tryNumber, MovePolicy policy) {
        this.cars = Cars.newInstance(carNames);
        this.tryNumber = new TryNumber(tryNumber);
        this.policy = policy;
    }

    public void race() {
        while(isKeepGoing()) {
            this.cars.move(policy);
            this.cars.save();
            this.tryNumber.decrease();
        }
    }

    private boolean isKeepGoing() {
        return this.tryNumber.isNotZero();
    }

    public Cars getCars() {
        return this.cars;
    }

    public Winners getWinners() {
        return new Winners(cars);
    }
}
