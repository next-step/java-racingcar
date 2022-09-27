package step3.cars;

import step3.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class RacingCars implements Cars {

    private final List<Car> cars;

    public RacingCars() {
        this(List.of());
    }

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public Cars carsWithAddCar(Car car) {
        final ArrayList<Car> existedCars = new ArrayList<>(cars);
        existedCars.add(car);
        return new RacingCars(Collections.unmodifiableList(existedCars));
    }

    @Override
    public Cars carsWithRemoveCar(Car car) {
        final ArrayList<Car> existedCars = new ArrayList<>(cars);
        existedCars.remove(car);
        return new RacingCars(Collections.unmodifiableList(existedCars));
    }

    @Override
    public Cars carsWithTurnUsed() {
        final List<Car> carsWithTurnUsed = cars.stream()
                .map(Car::movedCar)
                .collect(Collectors.toList());
        return new RacingCars(carsWithTurnUsed);
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
