package racing;

import racing.controller.Game;
import racing.view.InputView;

public class App {
  public static void main(String[] args){
    InputView inputView = new InputView();
    int carCount = inputView.inputCarCount();
    int attempt = inputView.inputPeriod();

    Game game = new Game();
    game.run(carCount, attempt);

  }
}
