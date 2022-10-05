package step3and4.game.car;

import step3and4.client.number.Number;
import step3and4.client.output.OutputView;

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
                    .map(numberOfCar -> new Car(number))
                    .collect(Collectors.toUnmodifiableList());

            return new Cars(cars);
        }

    }

}
