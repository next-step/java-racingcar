package step3;

import step3.domain.RacingGame;
import step3.view.InputScanner;

public class Main {
    public static void main(String[] args) {
        String inputNamesOfCars = InputScanner.getInputNamesOfCars();
        int inputNumberOfTry = InputScanner.getInputNumberOfTry();

        RacingGame racingGame = new RacingGame(
                inputNamesOfCars,
                inputNumberOfTry
        );

        racingGame.racingAll();
    }
}
