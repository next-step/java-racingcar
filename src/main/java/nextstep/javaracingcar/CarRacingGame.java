package nextstep.javaracingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final List<Car> cars;
    private final Round round;

    public CarRacingGame(final PositiveNumber carCount, final Round round, final CarEngine carEngine) {

        this.cars = this.createCars(carCount, carEngine);
        this.round = round;
    }

    private List<Car> createCars(final PositiveNumber carCount, final CarEngine carEngine) {
        final List<Car> initCars = new ArrayList<>();
        carCount.forEach(i -> initCars.add(new Car(String.valueOf(i), carEngine)));
        return initCars;
    }

    public boolean hasNextRound() {
        return this.round.hasNextRound();
    }

    public List<CarDashboard> runRound() {
        for (Car car : this.cars) {
            car.move();
        }
        this.round.run();
        return result();
    }

    public List<CarDashboard> result() {
        return cars.stream().map(Car::dashboard).collect(Collectors.toList());
    }
}
