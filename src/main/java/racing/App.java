package racing;

import racing.controller.Game;
import racing.view.InputView;

public class App {
  public static void main(String[] args){
    int carCount = InputView.inputCarCount();
    int attempt = InputView.inputPeriod();

    Game game = new Game(carCount, attempt);
    game.run();

  }
}
