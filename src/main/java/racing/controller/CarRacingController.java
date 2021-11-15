package racing.controller;

import racing.model.CarRacingGame;
import racing.view.TerminalInputView;
import racing.view.TerminalOutputView;

import java.util.List;

public class CarRacingController {

    private CarRacingController() {}

    public static void start() {
        CarRacingGame carRacingGame = createCarRacingGameFromInput();
        play(carRacingGame);
    }

    private static CarRacingGame createCarRacingGameFromInput() {
        List<String> names = TerminalInputView.inputNamesOfCar();
        int numberOfMove = TerminalInputView.inputNumberOfMove();

        return new CarRacingGame(names, numberOfMove);
    }

    private static void play(CarRacingGame carRacingGame) {
        TerminalOutputView.printEmptyLine();
        TerminalOutputView.printStartSentence();

        while (carRacingGame.isPossibleToMove()) {
            carRacingGame.moveCars();
            TerminalOutputView.printCars(
                    carRacingGame.getCars());
        }

        TerminalOutputView.printWinnersCars(
                carRacingGame.extractWinners());
    }
}
