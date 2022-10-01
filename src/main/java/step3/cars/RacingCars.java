package step3.cars;

import step3.car.Car;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars implements Cars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Cars carsWithTurnUsed() {
        List<Car> movedCars = cars.stream()
                .map(Car::movedCar)
                .collect(Collectors.toUnmodifiableList());
        return new RacingCars(movedCars);
    }

    @Override
    public void printPosition() {
        cars.forEach(Car::printPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
