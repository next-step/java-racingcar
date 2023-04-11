package study.racingcar;

import java.util.List;

public class Game {

    private List<Car> carList;
    private int numberOfGames;

    public Game () {
        this.carList = SettingGame.createCars(InputView.setCars());
        this.numberOfGames = InputView.setGames();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getNumberOfGames() {
        return numberOfGames;
    }
}
