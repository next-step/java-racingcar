package carracing;

import carracing.move_strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public static Cars makeCars(List<String> carNames) {
        return new Cars(carNames.stream().map(Car::new).collect(Collectors.toList()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach((car) -> car.move(moveStrategy.getMovePoint()));
    }

    private int getMaxPosition() {
        return this.cars.stream().max(Comparator.comparing(Car::getPosition)).get().getPosition();
    }

    public List<Car> getFastestCars() {
        return this.cars.stream().filter(car -> car.getPosition().equals(getMaxPosition())).collect(Collectors.toList());
    }
}
