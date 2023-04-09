package game;

import java.util.stream.IntStream;

public class CarRacing {
    private final int racingRep;
    private final Cars cars;

    public CarRacing(RacingOptions options) {
        this.racingRep = options.racingRep();
        this.cars = Cars.generate(options.carCount());
    }


    public void start() {
        IntStream.range(0, racingRep)
                .forEach(rep -> cars.drive());
    }

    public int carCount() {
        return cars.count();
    }

    public int racingCount() {
        return cars.racingCount();
    }
}