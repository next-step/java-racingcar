import racingcar.controller.RacingGameController;
import racingcar.strategy.RandomMovingStrategy;

public class RacingCarApplication {

  public static void main(String[] args) {
    RacingGameController racingGameController = new RacingGameController(
        new RandomMovingStrategy());
    racingGameController.start();
  }
}
