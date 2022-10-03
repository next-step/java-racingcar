package racing.service;

import racing.model.Car;
import racing.model.Cars;
import racing.model.RaceResult;
import racing.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private Cars cars;

    public Cars generateCar(String[] carNames) {
        Cars cars = new Cars();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public RaceResult race(String[] names, int count) {
        RaceResult raceResult = new RaceResult();
        cars = generateCar(names);

        for (int i = 0; i < count; i++) {
            raceStep(cars);
            raceResult.checkLap(cars.getLapTime());
        }

        raceResult.checkWinner(cars.getWinners());
        return raceResult;
    }

    private void raceStep(Cars cars) {
        cars.race();
    }
}
