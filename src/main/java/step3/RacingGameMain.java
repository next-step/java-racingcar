package step3;

import step3.view.RacingGameView;

public class RacingGameMain {
  public static void main(String[] args) {
    int numberOfCar = RacingGameView.getNumberOfCarFromUser();
    int gameCount = RacingGameView.getGameCountFromUser();

    RacingGame game = new RacingGame();
    game.start(numberOfCar, gameCount);
  }
}
