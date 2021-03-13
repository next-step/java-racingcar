package dev.djoon.racingcar;

import dev.djoon.racingcar.controller.GameController;

public class GameApp {
  public static void main(String[] args) {
    GameController gameController = new GameController();
    gameController.inputGameInfo();
    gameController.start();
  }
}
