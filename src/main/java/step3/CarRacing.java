package step3;

import java.util.List;
import java.util.stream.IntStream;

public class CarRacing {

    private final List<Car> cars;
    private int tryCount;

    public CarRacing(int carCount, int tryCount) {
        if (carCount < 2 || carCount > 10) {
            throw new RuntimeException();
        }

        if (tryCount < 1 || tryCount > 10) {
            throw new RuntimeException();
        }

        this.cars = IntStream.range(0, carCount)
            .mapToObj(i -> new Car(i + 1))
            .toList();
        this.tryCount = tryCount;
    }

    public List<Car> currentCars() {
        return cars;
    }

    public List<Car> racingCars() {
        if (tryCount < 1) {
            throw new RuntimeException();
        }

        tryCount--;
        return currentCars();
    }
}
