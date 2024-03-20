package racing.controller;

import racing.domain.Game;
import racing.view.Output;

public class GameController {

    public static Game createGame(String nameOfCar) {
        return new Game(nameOfCar);
    }

    public static Game playGame(Game game, int attempts) {
        Output.showStartOfGame();

        for (int i = 0; i < attempts; i++) {
            game.playSession();
            Output.showSessionStatus(game.getAttendedCars());
        }

        return game;
    }
}
