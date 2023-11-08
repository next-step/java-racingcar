package carracing.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public static Cars makeCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(int i) {
        cars.forEach((car) -> car.move(i));
    }

    private Car getMaxPosition() {
        return this.cars.stream().max(comparing(Car::getPosition)).get();
    }

    public List<Car> getFastestCars() {
        Car maxPosition = getMaxPosition();
        return this.cars.stream().filter(maxPosition::isSamePosition).collect(Collectors.toList());
    }
}
