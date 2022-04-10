package racing;

import racing.controller.Game;
import racing.domain.NumberOfCars;
import racing.domain.NumberOfRound;
import racing.ui.InputView;

public class Application {

    public static void main(String[] args) {
        final NumberOfCars numberOfCars = InputView.inputNumberOfCars();
        final NumberOfRound numberOfRound = InputView.inputNumberOfRound();

        Game game = new Game(numberOfCars, numberOfRound);
        game.start();
        game.end();
    }
}
