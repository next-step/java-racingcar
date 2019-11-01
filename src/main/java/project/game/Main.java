package project.game;

import project.game.controller.RacingGameController;
import project.game.domain.GameType;
import project.game.view.RacingGameView;

public class Main {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new RacingGameView());
        racingGameController.start(GameType.RANDOM);
    }
}
