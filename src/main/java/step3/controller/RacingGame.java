package step3.controller;

import step3.domain.Car;
import step3.domain.Cars;
import step3.utils.GameRule;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class RacingGame {
    private final GameRule gameRule;
    private final Cars cars;
    private final int numberOfAttemps;

    public RacingGame(int numberOfAttemps, GameRule gameRule, Cars cars) {
        this.numberOfAttemps = numberOfAttemps;
        this.gameRule = gameRule;
        this.cars = cars;
    }

    public int getNumberOfCars() {
        return cars.getNumberOfCars();
    }

    public void startRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < numberOfAttemps; i++) {
            System.out.println("[" + (i + 1) + "]" + " round");
            raceByRound();
        }
    }

    public void raceByRound() {
        for (int i = 0; i < cars.getNumberOfCars(); i++) {
            Car car = cars.getCar(i);
            car.move(gameRule);
            ResultView.printRaceResult(car.getName(), car.getScore(), InputView.getSymbol());
        }
        System.out.println();
    }

    public List<String> getChampion() {
        return cars.decisionOfChampion();
    }
}
