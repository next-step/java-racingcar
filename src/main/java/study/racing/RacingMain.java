package study.racing;

import study.racing.controller.RacingGame;
import study.racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingMain {


    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        List<Car> cars = racingGame.carSetting();
        int trial = racingGame.getTrial();

        racingGame.start();
        while(trial-->0) {
            racingGame.moveCars(cars);
            racingGame.displayCars(cars);
        }

        racingGame.end(cars);
    }
}
