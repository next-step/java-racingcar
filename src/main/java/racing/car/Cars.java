package racing.car;

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
        Location bestLocation =
                new Location(values.values().stream()
                        .map(Car::getLocation)
                        .mapToInt(Location::getValue)
                        .max()
                        .getAsInt()
                );

        Cars cars = new Cars();
        cars.addAll(values.values().stream()
                .filter(c -> c.getLocation().equals(bestLocation))
                .collect(Collectors.toList())
        );
        return cars;
    }

    public Car get(Name name) {
        return values.get(name);
    }

    public boolean containsName(Name name) {
        return this.values.containsKey(name);
    }

    public void addAll(List<Car> cars) {
        for (Car iCar : cars)
            add(iCar);
    }

    public void add(Car car) {
        if (values.containsKey(car.getName()))
            throw new DuplicateKeyException("중복된 자동차 이름이 존재 합니다.");
        values.put(car.getName(), car);
    }

    public void moveAll(Fuel fuel) {
        for (Car car : this)
            car.move(fuel);
    }

    public int size() {
        return values.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return values.values().iterator();
    }
}
