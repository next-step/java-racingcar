package study.step3;

import study.domain.racingGame.RacingGame;

public class RacingGameApp {
  public static void main(String[] args) {
    RacingGame game = new RacingGame();
    game.ready();
    game.start();
  }
}