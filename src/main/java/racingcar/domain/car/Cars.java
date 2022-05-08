package racingcar.domain.car;

import racingcar.domain.policy.MovePolicy;
import racingcar.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String names) {
        this.cars = initCars(names);
    }

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    private List<Car> initCars(String carNames) {
        String[] names = StringUtils.split(carNames);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(new Participant(name)));
        }

        return cars;
    }

    public void move(MovePolicy policy) {
        for (Car car : cars) {
            car.move(policy.apply());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
