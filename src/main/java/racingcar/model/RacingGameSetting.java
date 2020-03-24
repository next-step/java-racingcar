package racingcar.model;

import racingcar.policy.MovingPolicy;
import racingcar.policy.RandomMovingPolicy;

import java.util.ArrayList;
import java.util.List;

public class RacingGameSetting {
    private static final String CAR_NAME_SEPARATOR = ",";
    private MovingPolicy movingPolicy;
    private Cars cars;
    private int time;

    public RacingGameSetting(final MovingPolicy movingPolicy, final String carNames, final int time) {
        this.movingPolicy = settingMovingPolicy(movingPolicy);
        this.cars = settingCars(carNames);
        this.time = time;
    }

    public MovingPolicy getMovingPolicy() {
        return movingPolicy;
    }

    public Cars getCars() {
        return cars;
    }

    public int getTime() {
        return time;
    }

    private MovingPolicy settingMovingPolicy(MovingPolicy movingPolicy) {
        if (movingPolicy == null) {
            return new RandomMovingPolicy();
        }
        return movingPolicy;
    }

    private Cars settingCars(final String carNames) {
        String[] names = carNames.split(CAR_NAME_SEPARATOR);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name, Car.DEFAULT_DISTANCE));
        }
        return new Cars(cars);
    }
}
