package step5.controller;

import step5.model.CarRacingGame;
import step5.view.GameInput;
import step5.view.GameOutput;

public class Main {

    public static void main(String[] args) {
        String[] carNames = GameInput.readCarNames();
        int roundCount = GameInput.readRoundCount();
        CarRacingGame carRacingGame = new CarRacingGame(roundCount, carNames);

        System.out.println("실행 결과");
        while (carRacingGame.hasMoreRounds()) {
            carRacingGame.moveCars();
            GameOutput.printCarPaths(carRacingGame);
            System.out.println();
        }

        GameOutput.printWinners(carRacingGame.getWinners());
    }
}
