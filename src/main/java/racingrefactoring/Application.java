package racingrefactoring;

import racingrefactoring.controller.RacingCarController;
import racingrefactoring.domain.RandomMoveStrategy;

public class Application {

  public static void main(String[] args) {
    RacingCarController racingCarController = new RacingCarController(new RandomMoveStrategy());
    racingCarController.startGame();
  }

}
