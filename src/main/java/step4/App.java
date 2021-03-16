package step4;

import step4.controller.Game;
import step4.view.InputView;

public class App {
  public static void main(String[] args){
    InputView inputView = new InputView();
    String carNames = inputView.inputCarNames();
    int attempt = inputView.inputPeriod();

    Game game = new Game();
    game.run(carNames, attempt);

  }
}
