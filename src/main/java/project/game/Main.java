package project.game;

import project.game.controller.RacingGameController;
import project.game.domain.GameType;
import project.game.view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new ConsoleView());
        racingGameController.start(GameType.RANDOM);
    }
}
