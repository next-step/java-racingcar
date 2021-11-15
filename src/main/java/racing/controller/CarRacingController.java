package racing.controller;

import racing.model.CarRacingGame;
import racing.view.TerminalInputView;
import racing.view.TerminalOutputView;

import java.util.List;

public class CarRacingController {

    public void start() {
        CarRacingGame carRacingGame = createCarRacingGameFromInput();
        play(carRacingGame);
    }

    private CarRacingGame createCarRacingGameFromInput() {
        List<String> names = TerminalInputView.inputNamesOfCar();
        int numberOfMove = TerminalInputView.inputNumberOfMove();

        return new CarRacingGame(names, numberOfMove);
    }

    private void play(CarRacingGame carRacingGame) {
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
