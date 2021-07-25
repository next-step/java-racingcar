package racing.domain.car.entity;

import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;
import racing.domain.car.vo.fuel.Fuel;
import racing.exception.EmptyCarException;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car>, Cloneable {
    private final Set<Car> values;

    public Cars(Set<Car> values) {
        this.values = values;
    }

    public Cars() {
        this(new HashSet<>());
    }

    private Location bestLocation() {
        return values.stream()
                .map(Car::location)
                .max(Comparator.comparing(Location::value))
                .orElse(Location.empty());
    }

    public Cars bestCars() {
        if (isEmpty())
            throw new EmptyCarException();

        Location bestLocation = bestLocation();
        return new Cars(
                values.stream()
                .filter(c -> c.checkLocation(bestLocation))
                .collect(Collectors.toSet())
        );
    }

    public void moveAll(Fuel fuel) {
        for (Car car : this)
            car.move(fuel);
    }

    /* 테스트가 필요한 Foward 메소드들 */
    public void add(Car car) {
        if (values.contains(car))
            throw new IllegalStateException("중복된 자동차 이름이 존재 합니다.");
        values.add(car);
    }

    public void addAll(Cars cars) {
        for (Car iCar : cars)
            add(iCar);
    }

    @Override
    public Object clone() {
        return new Cars(
                values.stream()
                        .map(c -> (Car) c.clone())
                        .collect(Collectors.toSet())
        );
    }

    /* 단순 Forward 메소드들 (테스트 X) */
    public boolean isEmpty() {
        return values.isEmpty();
    }

    public boolean contains(Car car) {
        return values.contains(car);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.iterator();
    }
}
