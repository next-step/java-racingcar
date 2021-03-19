package step3.controller;

import step3.domain.Car;
import step3.domain.Cars;
import step3.service.GameRule;

import java.util.List;

public class RacingGame {
    private final GameRule gameRule;
    private final Cars cars;
    private final int numberOfCars;
    private final int attemps;

    public RacingGame(int numberOfCars, int attemps, GameRule gameRule, Cars cars) {
        this.numberOfCars = numberOfCars;
        this.attemps = attemps;
        this.gameRule = gameRule;
        this.cars = cars;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public void doRace() {
        for (int i = 0; i < attemps; i++) {
            raceByRound();
        }
    }

    public void raceByRound() {
        for (int i = 0; i < numberOfCars; i++) {
            Car car = cars.getCars().get(i);
            car.move(gameRule);
        }
    }

}
