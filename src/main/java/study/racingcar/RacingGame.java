package study.racingcar;

import java.util.List;

public class RacingGame {

    private List<Car> cars;
    private int lastLapCheck;

    public RacingGame(RacingGameInputs racingGameInputs) {
        this.cars = SettingGame.createCars(racingGameInputs);
        this.lastLapCheck = 0;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void nextLap() {
        this.lastLapCheck++;
    }
    public boolean isOver(int numberOfGames) {

        return numberOfGames <= this.lastLapCheck;
    }

    public void moveCar() {

        for(Car car : this.cars) {

            car.move(GenerateNumber.random());

            ResultView.resultGame(car);
        }

        ResultView.emptyLine();
    }
}
