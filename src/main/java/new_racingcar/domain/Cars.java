package new_racingcar.domain;

import new_racingcar.constant.MsgConstants;
import new_racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names, MoveStrategy moveStrategy) {
        isNamesSizeValie(names);
        this.cars = createCar(names, moveStrategy);
    }

    private void isNamesSizeValie(List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException(MsgConstants.CAR_NAME_ERROR_MESSAGE);
        }
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> createCar(List<String> names, MoveStrategy moveStrategy) {
        List<Car> cars = new ArrayList<>();

        int nameSize = names.size();
        for(int i = 0; i < nameSize; i++) {
            cars.add(new Car(names.get(i), moveStrategy));
        }

        return cars;
    }

    public Cars run() {
        List<Car> moveCars = cars.stream()
                .map(c -> c.move())
                .collect(Collectors.toList());

        return new Cars(moveCars);
    }

    public Cars run(MoveStrategy moveStrategy) {
        List<Car> moveCars = cars.stream()
                .map(c -> c.move(moveStrategy))
                .collect(Collectors.toList());

        return new Cars(moveCars);
    }

    public List<Car> getUnmodifiableCars() {
        return Collections.unmodifiableList(cars);
    }
}
