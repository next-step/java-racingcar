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

    void run() {
        for (Car car : cars) {
            car.run();
        }
    }

    void printDistance() {
        for (Car car : cars) {
            ResultView.printDistance(car.getName(), car.getDistance());
        }
    }

    List<String> findWinnerNames() {
        Car maxDistanceCar = findMaxDistanceCar();
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.isDistance(maxDistanceCar)) {
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    Car findMaxDistanceCar() {
        Car maxDistanceCar = cars.get(0);
        for (int i = 1; i < cars.size() - 1; i ++) {
            Car car = cars.get(i + 1);
            if (car.hasLogDistanceThan(maxDistanceCar)) {
                maxDistanceCar = car;
            }
        }

        return maxDistanceCar;
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
}
