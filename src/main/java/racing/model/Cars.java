package racing.model;

import java.util.*;
import java.util.stream.Collectors;

/**
 * .
 */
public class Cars {

    private final List<Car> cars;

    public Cars(String carName) {
        cars = Arrays.stream(carName.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Cars(List<Car> cars) {
        List<Car> carList = new LinkedList<>();
        for (Car car : cars) {
            carList.add(new Car(car));
        }
        this.cars = carList;
    }

    public List<Car> moveCars() {
        cars.forEach(car -> car.move(ConditionGenerator.generate()));
        return cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String winners() {
        StringJoiner result = new StringJoiner(", ");
        cars.stream()
                .filter(car -> car.intPosition() == getTopPosition(cars))
                .forEach(car -> result.add(car.stringName()));
        return result.toString();
    }

    public int getTopPosition(List<Car> roundRecord) {
        return roundRecord.stream()
                .mapToInt(Car::intPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
