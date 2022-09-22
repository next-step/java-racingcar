package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.HashMap;

public class RacingCarTable {
    private final HashMap<Integer, Car> table = new HashMap<>();
    private static int sequence = 0;

    public void save(Car car) {
        table.put(sequence++, car);
    }

    public void saveAll(Cars cars) {
        cars.getCars()
            .forEach(this::save);
    }

    public Cars findAll() {
        return new Cars(new ArrayList<>(table.values()));
    }
}
