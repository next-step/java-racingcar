package game.service;

import game.domain.Cars;
import game.view.ResultView;

import java.util.stream.IntStream;

public class CarRacing {
    private final int racingRep;
    private final Cars cars;

    public CarRacing(RacingOptions options) {
        this.racingRep = options.racingRep();
        this.cars = Cars.generate(options.carCount());
    }

    public void start() {
        ResultView.displayExecuteResultMessage();
        IntStream.range(0, racingRep)
                .forEach(rep -> {
                    cars.drive();
                    ResultView.displayGameResult(cars.carPositions());
                });
    }
}