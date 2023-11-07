package study.carracing.controller;

import java.util.ArrayList;
import java.util.List;
import study.carracing.domain.Car;
import study.carracing.domain.RacingCars;
import study.carracing.ui.ResultView;
import study.carracing.util.RandomGeneratorImpl;

public class RacingController {

    private RacingCars racingCars;

    public void start(int carCount, int tryCount) {
        this.racingCars = addRacingCars(carCount);
        this.move(tryCount);
    }

    private void move(int tryCount) {
        ResultView.outputTitle();
        for (int i = 0; i < tryCount; i++) {
            racingCars.move();
            ResultView.outputResult(racingCars.getCars());
        }
    }

    private RacingCars addRacingCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(new RandomGeneratorImpl()));
        }

        return new RacingCars(cars);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
