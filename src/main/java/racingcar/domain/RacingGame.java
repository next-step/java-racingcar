package racingcar.domain;

import racingcar.domain.car.Cars;
import racingcar.domain.policy.MovePolicy;

public class RacingGame {

    private final MovePolicy policy;
    private final Cars cars;
    private final TryNumber tryNumber;

    public RacingGame(String carNames, int tryNumber, MovePolicy policy) {
        this.cars = new Cars(carNames);
        this.tryNumber = new TryNumber(tryNumber);
        this.policy = policy;
    }


    public void race() {
        this.tryNumber.decrease();
        this.cars.move(policy);
    }

    public boolean isKeepGoing() {
        return this.tryNumber.isNotZero();
    }

    public Cars getCars() {
        return this.cars;
    }

    public Winners getWinners() {
        return new Winners(cars);
    }


}
