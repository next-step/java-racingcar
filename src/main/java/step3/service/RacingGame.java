package step3.service;

import step3.domain.Car;
import step3.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final GameRule gameRule;
    private final int numberOfCars;
    private final int attemps;

    public RacingGame(int numberOfCars, int attemps, GameRule gameRule) {
        this.numberOfCars = numberOfCars;
        this.attemps = attemps;
        this.gameRule = gameRule;
    }

    public Cars initCars() {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            carList.add(new Car());
        }
        return new Cars(carList);
    }

    public void doRace(Cars cars) {
        for (int i = 0; i < attemps; i++) {
            raceByRound(cars);
        }
    }

    public void raceByRound(Cars cars) {
        for (int i = 0; i < numberOfCars; i++) {
            Car car = cars.getCars().get(i);
            car.move(gameRule);
        }
    }

    public int getAttemps() {
        return attemps;
    }

}
