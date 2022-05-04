package racingcar.v2.domain;

import racingcar.v2.domain.car.Car;
import racingcar.v2.domain.car.Participant;
import racingcar.v2.domain.policy.MovePolicy;
import racingcar.v2.domain.policy.ZeroToNineRandomMovePolicy;
import racingcar.v2.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {


    private static final int RACING_POLICY_VALUE = 10;

    private final MovePolicy policy;
    private final List<Car> cars;
    private int tryNumber;

    public RacingGame(String carNames, int tryNumber) {
        this(carNames, tryNumber, new ZeroToNineRandomMovePolicy());
    }

    public RacingGame(String carNames, int tryNumber, MovePolicy policy) {
        this.cars = initCars(carNames);
        this.tryNumber = tryNumber;
        this.policy = policy;
    }

    private List<Car> initCars(String carNames) {
        String[] names = StringUtils.split(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(new Participant(name)));
        }

        return cars;
    }

    public void race() {
        this.tryNumber--;
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(policy.apply(RACING_POLICY_VALUE));
        }
    }

    public boolean racing() {
        return this.tryNumber > 0;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        return Winners.findWinner(cars);
    }

}
