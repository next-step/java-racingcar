package study.racingcar;

import java.util.List;

public class RacingGame {

    private List<Car> cars;
    private int numberOfGames;
    private int lastLapCheck;

    public RacingGame(RacingGameInputs racingGameInputs) {
        this.cars = SettingGame.createCars(racingGameInputs);
        this.numberOfGames = racingGameInputs.getNumberOfGames();
        this.lastLapCheck = 0;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void nextLap() {
        this.lastLapCheck++;
    }
    public boolean isOver() {

        return this.numberOfGames <= this.lastLapCheck;
    }

    public void moveCar() {

        for(Car car : this.cars) {

            car.move();
        }
    }
}
