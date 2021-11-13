package racingcar.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.strategy.RandomMoveStrategy;

public class Cars {

    private static final String DELIMITER = ",";

    private List<Car> cars;

    private Cars(String[] names) {
        this.cars = Arrays.stream(names)
            .map(Car::from)
            .collect(Collectors
                .toCollection(ArrayList::new));
    }

    public static Cars from(String name) {
        String[] names = name.split(DELIMITER);
        return new Cars(names);
    }

    public long size() {
        return cars.size();
    }

    public void moveCars() {
        cars.forEach(car -> car.move(new RandomMoveStrategy()));
    }

}
