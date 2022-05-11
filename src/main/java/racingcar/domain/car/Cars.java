package racingcar.domain.car;

import racingcar.domain.policy.MovePolicy;
import racingcar.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars newInstance(String carNames) {
        String[] names = StringUtils.split(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.newInstance(name));
        }

        return new Cars(cars);
    }

    public void move(MovePolicy policy) {
        for (Car car : cars) {
            car.move(policy);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void save() {
        for (Car car : cars) {
            car.save(RacingRecord.newInstance(car.isCurrentPosition()));
        }
    }
}
