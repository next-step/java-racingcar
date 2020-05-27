package racing_game.controller;

import racing_game.model.Game;
import racing_game.model.RacingGame;
import racing_game.view.RacingGameInput;

public class RacingGameController {
  public static void main(String[] args) {
    Game racingGame = new RacingGame(RacingGameInput.getNameOfCarsByScanner(),
        RacingGameInput.getTimeByScanner());

    racingGame.play();
  }
}
