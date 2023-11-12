package study.repository;

import study.domain.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryCarRepository implements CarRepository {
    private final Map<String, Car> store = new HashMap<>();

    @Override
    public Car save(Car car) {
        return store.put(car.getName(), car);
    }

    public Car findCarByName(Car car) {
        return store.get(car.getName());
    }

    @Override
    public List<Car> findCarAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void clearStore() {
        store.clear();
    }
}
