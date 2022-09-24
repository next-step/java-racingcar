package racingcar.repository;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RacingCarRepository {
    private final Map<Integer, Car> repository = new ConcurrentHashMap<>();
    private static int sequence = 0;

    public synchronized void save(Car car) {
        repository.put(sequence++, car);
    }

    public void saveAll(Cars cars) {
        cars.getElements()
            .forEach(this::save);
    }

    public Cars findAll() {
        return Cars.of(repository.values());
    }

    public void clear() {
        repository.clear();
    }
}
