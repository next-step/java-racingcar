package step3.service;

import step3.domain.Car;
import step3.domain.Cars;

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
