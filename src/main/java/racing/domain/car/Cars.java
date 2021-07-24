package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;
import racing.exception.EmptyCarException;

import java.util.*;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final Map<Name, Car> values;

    public Cars(Map<Name, Car> values) {
        this.values = values;
    }

    public Cars() {
        this(new HashMap<>());
    }

    private Location bestLocation() {
        return values.values().stream()
                .map(Car::location)
                .max(Comparator.comparing(Location::value))
                .orElse(Location.empty());
    }

    public Cars betCars() {
        if (values.isEmpty())
            throw new EmptyCarException();

        Location bestLocation = bestLocation();
        return new Cars(
                values.values().stream()
                .filter(c -> c.checkLocation(bestLocation))
                .collect(Collectors.toMap(
                        Car::name, i -> i
                ))
        );
    }

    public void moveAll(Fuel fuel) {
        for (Car car : this)
            car.move(fuel);
    }

    /* 아래는 Forward 메소드 */
    public boolean containsName(Name name) {
        return this.values.containsKey(name);
    }

    public void add(Car car) {
        if (values.containsKey(car.name()))
            throw new IllegalStateException("중복된 자동차 이름이 존재 합니다.");
        values.put(car.name(), car);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.values().iterator();
    }
}
