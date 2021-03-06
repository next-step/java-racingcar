package dev.djoon.racingcar;

import dev.djoon.racingcar.ui.InputView;

public class GameApp {
  public static void main(String[] args) {
    RacingCarGame game = new RacingCarGame();

    InputView iv = new InputView(System.in);
    iv.inputCarQuantity(game);
    iv.inputLoopTimes(game);
    iv.close();

    game.start();
  }
}
