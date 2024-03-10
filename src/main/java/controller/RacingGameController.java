package controller;

import domain.Car;
import domain.RacingGame;
import domain.RandomMoveStrategy;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.play();
    }

    public void play() {
        int carCount = InputView.promptForCarCount();
        int moveCount = InputView.promptForMoveCount();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(new RandomMoveStrategy()));
        }
        RacingGame racingGame = new RacingGame(cars, moveCount);
        racingGame.play();
    }
}
