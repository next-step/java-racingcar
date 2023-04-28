package racing;

import racing.controller.RaceGame;
import racing.util.NameUtil;
import racing.view.InputView;

public class Main {
    public static void main(String[] args) {
        //int carNum = InputView.insertNumberOfCars();
        String carNames = InputView.insertNamesOfCars();
        int attemptsNum = InputView.insertNumberOfAttempts();

        RaceGame raceGame = new RaceGame();
        raceGame.startRacing(NameUtil.split(carNames), attemptsNum);
    }
}
