package step3.cars;

import step3.car.Car;
import step3.number.RandomNumber;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public RacingCars carsWithTurnUsed() {
        List<Car> movedCars = cars.stream()
                .map(Car::movedCar)
                .collect(Collectors.toUnmodifiableList());
        return new RacingCars(movedCars);
    }

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

    public static class Factory {

        private final int numberOfCars;

        public Factory(int numberOfCars) {
            this.numberOfCars = numberOfCars;
        }

        public RacingCars cars() {
            List<Car> cars = IntStream.range(0, numberOfCars)
                    .boxed()
                    .map(number -> new Car(new RandomNumber()))
                    .collect(Collectors.toUnmodifiableList());

            return new RacingCars(cars);
        }

    }

}
