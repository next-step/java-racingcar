package racing.domain.car;

import racing.domain.Location;
import racing.domain.Name;
import racing.domain.fuel.Fuel;
import racing.exception.DuplicateKeyException;
import racing.exception.EmptyCarException;

import java.util.*;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private final HashMap<Name, Car> values;

    public Cars(HashMap<Name, Car> values) {
        this.values = values;
    }

    public Cars() {
        this(new HashMap<>());
    }

    public Cars bestCars() {
        if (values.isEmpty())
            throw new EmptyCarException();

        // 가장 많은 거리를 이동한 자동차의 Location을 구한다.
        Comparator<Location> comparator = Comparator.comparing(Location::value);
        Location bestLocation = values.values().stream()
                .map(Car::location)
                .max(comparator)
                .orElse(Location.empty());

        Cars cars = new Cars();
        cars.addAll(values.values().stream()
                .filter(c -> c.checkLocation(bestLocation))
                .collect(Collectors.toList())
        );
        return cars;
    }

    public void moveAll(Fuel fuel) {
        for (Car car : this)
            car.move(fuel);
    }

    /* 아래는 Forward 메소드 */
    public boolean containsName(Name name) {
        return this.values.containsKey(name);
    }

    public void addAll(List<Car> cars) {
        for (Car iCar : cars)
            add(iCar);
    }

    public void add(Car car) {
        if (values.containsKey(car.name()))
            throw new DuplicateKeyException("중복된 자동차 이름이 존재 합니다.");
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
