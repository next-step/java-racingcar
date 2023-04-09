package study.racingcar;

import java.util.List;
import java.util.Random;

public class RacingCar {

    public static void main(String[] args){
        game();
    }

    public static void game() {

        InputView inputView = new InputView();

        int numberOfCars = inputView.setCars();
        int countOfGames = inputView.setGames();

        SettingGame settingGame = new SettingGame();

        settingGame.isCheckSetGame(numberOfCars, countOfGames);

        RacingGame racingGame = new RacingGame();

        racingGame.gameStart(numberOfCars, countOfGames);
    }
}
