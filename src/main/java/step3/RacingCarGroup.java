package step3;

import step3.manager.RacingManager;
import step3.manager.RandomManager;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGroup {
    private final int ZERO = 0;
    private final List<Car> cars;

    public RacingCarGroup(Count count) {
        RacingManager racingManager = new RandomManager();

        this.cars = IntStream.range(ZERO, count.getCount())
                        .mapToObj(i -> new Car(racingManager))
                        .collect(Collectors.toList());
    }

    public Count carsCount() {
        return new Count(cars.size());
    }

    public void carsRun() {
        cars.stream()
                .forEach(Car::run);
    }

    public List<Position> carsCurrentPosition() {
        return cars.stream()
                .map(car -> new Position(car.currentPosition()))
                .collect(Collectors.toList());
    }
}
