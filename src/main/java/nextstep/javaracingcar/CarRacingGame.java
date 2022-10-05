package nextstep.javaracingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final List<Car> cars;
    private PositiveNumber remainRound;

    public CarRacingGame(final PositiveNumber carCount, final PositiveNumber roundCount, final CarEngine carEngine) {

        this.cars = new ArrayList<>();
        carCount.loop(i -> this.cars.add(new Car(String.valueOf(i), carEngine)));
        this.remainRound = roundCount;
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
