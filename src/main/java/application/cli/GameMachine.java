package application.cli;

import domain.service.Game;

public class GameMachine {
    private final Game game;

    public GameMachine(Game game) {
        this.game = game;
    }

    public void start() {
        game.run();
    }
}
