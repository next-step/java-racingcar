package game.service;

import game.domain.Cars;
import game.view.ResultView;

import java.util.stream.IntStream;

public class CarRacing {
    private final int racingRep;
    private final Cars cars;
    private final ResultView resultView;

    public CarRacing(RacingOptions options) {
        this.racingRep = options.racingRep();
        this.cars = Cars.generate(options.carCount());
        this.resultView = new ResultView(cars);
    }


    public void start() {
        IntStream.range(0, racingRep)
                .forEach(rep -> cars.drive());
    }

    public void end() {
        resultView.show();
    }
}