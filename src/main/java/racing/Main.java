package racing;

import racing.controller.RaceGame;
import racing.view.InputView;

public class Main {
    public static void main(String[] args) {
        int carNum = InputView.insertNumberOfCars();
        int attemptsNum = InputView.insertNumberOfAttempts();

        RaceGame raceGame = new RaceGame();
        raceGame.startRacing(carNum, attemptsNum);
    }
}
