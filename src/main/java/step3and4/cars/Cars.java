package step3and4.cars;

import step3and4.car.Car;
import step3and4.number.Number;
import step3and4.output.OutputView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars carsWithTurnUsed() {
        List<Car> movedCars = cars.stream()
                .map(Car::movedCar)
                .collect(Collectors.toUnmodifiableList());
        return new Cars(movedCars);
    }

    public void printPosition() {
        cars.forEach(Car::printPosition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars that = (Cars) o;
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

        public Cars cars(Number number, OutputView outputView) {
            List<Car> cars = IntStream.range(0, numberOfCars)
                    .boxed()
                    .map(numberOfCar -> new Car(number, outputView))
                    .collect(Collectors.toUnmodifiableList());

            return new Cars(cars);
        }

    }

}
