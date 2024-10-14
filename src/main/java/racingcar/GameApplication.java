package racingcar;


import racingcar.controller.GameController;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

public class GameApplication {
  public static void main(String[] args) {
    MoveStrategy moveStrategy = new RandomMoveStrategy();
    GameController gameController = new GameController(moveStrategy);
    gameController.startGame();
  }
}
