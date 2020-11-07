package racing;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class CarRacing {

    private final Cars cars;
    private int maxLaps = 0;

    public CarRacing(int numberOfCars,int maxLaps) {
        this.cars = new Cars(numberOfCars);
        this.maxLaps = maxLaps;
        start();
    }

    public List<Car> getRacingCars() {
        return cars.getCars();
    }

    private void start() {
        IntStream.range(0,maxLaps)
                .filter(i -> i < maxLaps)
                .forEach(e -> cars.moves());
    }
}
