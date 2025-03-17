package car_racing.domain.model;

import car_racing.domain.strategy.CarMovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {
    private static final int DEFAULT_MOVE_DISTANCE = 1;

    private final List<Car> cars;
    private final CarMovingStrategy movingStrategy;

    public Cars(List<String> namesOfCars, CarMovingStrategy movingStrategy) {
        this.cars = new ArrayList<>();
        this.movingStrategy = movingStrategy;
        for (String namesOfCar : namesOfCars) {
            this.cars.add(new Car(namesOfCar));
        }
    }

    public void moveAll() {
        cars.forEach(car -> {
            int distance = 0;
            if (movingStrategy.movable()) distance = DEFAULT_MOVE_DISTANCE;
            car.move(distance);
        });
    }

    public void forEach(Consumer<Car> action) {
        cars.forEach(action);
    }

    public RaceResults getRaceResults() {
        List<RaceResult> raceResults = cars.stream()
                .map(Car::getRaceResult)
                .collect(Collectors.toList());
        return new RaceResults(raceResults);
    }
}
