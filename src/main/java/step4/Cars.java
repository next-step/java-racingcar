package step4;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createWithDefaultPosition(Names names) {
        List<Car> cars = names.getNames().stream().map(name -> Car.createWithDefaultPosition(name))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public static Cars create(List<Car> cars) {
        return new Cars(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public Cars move(MoveStrategy moveStrategy) {
        List<Car> moveCars = cars.stream().map(car -> car.moveOrStop(moveStrategy))
                .collect(Collectors.toList());

        return create(moveCars);
    }

    @Override
    public String toString() {
        return this.cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

    public Winners getWinner() {
        Car winPosition = getWinPositionCar();
        List<Name> winnerNameList = cars.stream()
                .filter(car -> car.equalsPosition(winPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
        return Winners.create(winnerNameList);
    }

    private Car getWinPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }
}
