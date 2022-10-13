package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Cars(final String names) {
        List<String> carNames = Arrays.asList(names.split(","));
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        this.cars = cars;
    }

    public void run() {
        RandomNumMovingStrategy movingStrategy = new RandomNumMovingStrategy();
        for (Car car : cars) {
            car.run(movingStrategy);
        }
    }

    public Car findWinner() {
        return cars.stream()
                .reduce((car, otherCar) -> car.isWinner(otherCar) ? car : otherCar)
                .get();
    }

    public List<String> findWinnerNames() {
        Car winner = findWinner();

        return cars.stream()
                .filter(car -> car.isWinner(winner))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
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
        return super.hashCode();
    }

    public List<Car> getCars() {
        return cars.stream().collect(Collectors.toList());
    }
}
