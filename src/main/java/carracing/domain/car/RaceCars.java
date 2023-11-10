package carracing.domain.car;

import carracing.domain.race.move.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class RaceCars {
    private final List<Car> cars = new ArrayList<>();

    public RaceCars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public static RaceCars makeCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        return new RaceCars(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach((car) -> car.move(moveStrategy.getMovePoint()));
    }

    private Car getMaxPosition() {
        return this.cars.stream().max(comparing(Car::getPosition)).get();
    }

    public List<Car> getFastestCars() {
        Car maxPosition = getMaxPosition();
        return this.cars.stream().filter(maxPosition::isSamePosition).collect(Collectors.toList());
    }
}
