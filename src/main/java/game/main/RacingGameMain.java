package game.main;

import game.*;

import java.util.List;

public class RacingGameMain {

    public static void main(String[] args) {

        List<Car> cars = InputRacingPlayer.createInstance().getCarPlayer();

        int numberOfAttempts = InputRacingPlayer.createInstance().getRacingCount();

        RacingGame.create().racingGameStart(cars, numberOfAttempts);

    }

}
