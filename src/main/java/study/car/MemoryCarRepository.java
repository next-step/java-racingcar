package study.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryCarRepository implements CarRepository {
    private static Map<Long, Car> store = new HashMap<>();
    private static long SEQUENCE = 0L;

    @Override
    public long save(Car car) {
        car.setId(++SEQUENCE);
        car.setStatus("");
        store.put(car.getId(), car);
        return car.getId();
    }

    @Override
    public Car findCarById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Car> findCarAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
