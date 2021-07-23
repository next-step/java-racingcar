package racing.car;

import racing.exception.DuplicateKeyException;

import java.util.*;

public class Cars implements Iterable<Car> {
    private HashMap<Name, Car> values;

    public Cars() {
        values = new HashMap<>();
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
