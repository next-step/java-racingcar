package study.racingcar;

import java.util.List;

public class RacingCar {

    public static void game() {

        int numberOfCars = InputView.setCars();
        int numberOfGames = InputView.setGames();

        if(SettingGame.isReadyToGame(numberOfCars, numberOfGames)){
            List<Car> cars = SettingGame.createCars(numberOfCars);

            RacingGame.gameStart(cars, numberOfGames);
        }
    }
}
