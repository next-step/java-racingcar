package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameSetting {
    private static final String CAR_NAME_SEPARATOR = ",";

    private Cars cars;
    private int time;

    public RacingGameSetting(final String carNames, final int time) {
        this.cars = settingCars(carNames);
        this.time = time;
    }

    public Cars getCars() {
        return cars;
    }

    public int getTime() {
        return time;
    }

    private Cars settingCars(final String carNames) {
        String[] names = carNames.split(CAR_NAME_SEPARATOR);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(new CarName(name), Car.DEFAULT_DISTANCE));
        }
        return new Cars(cars);
    }
}
