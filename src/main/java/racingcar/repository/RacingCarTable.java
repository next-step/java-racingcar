package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RacingCarTable {
    private final Map<Integer, Car> table = new ConcurrentHashMap<>();
    private static int sequence = 0;

    public void save(Car car) {
        table.put(sequence++, car);
    }

    public void saveAll(Cars cars) {
        cars.getElements()
            .forEach(this::save);
    }

    public Cars findAll() {
        return Cars.of(table.values());
    }

    public void clear() {
        table.clear();
    }
}
