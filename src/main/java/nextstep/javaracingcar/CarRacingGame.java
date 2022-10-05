package nextstep.javaracingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final List<Car> cars;
    private PositiveNumber remainRound;

    public CarRacingGame(final PositiveNumber carCount, final PositiveNumber roundCount, final CarEngine carEngine) {

        this.cars = this.createCars(carCount, carEngine);
        this.remainRound = roundCount;
    }

    private List<Car> createCars(final PositiveNumber carCount, final CarEngine carEngine) {
        final List<Car> initCars = new ArrayList<>();
        carCount.loop(i -> initCars.add(new Car(String.valueOf(i), carEngine)));
        return initCars;
    }

    public boolean hasNextRound() {
        return this.remainRound.compareTo(PositiveNumber.ZERO) > 0;
    }

    public List<CarDashboard> runRound() {
        for (Car car : this.cars) {
            car.move();
        }
        this.remainRound = this.remainRound.decrease();
        return result();
    }

    public List<CarDashboard> result() {
        return cars.stream().map(Car::dashboard).collect(Collectors.toList());
    }
}
