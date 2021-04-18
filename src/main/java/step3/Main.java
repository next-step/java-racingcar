package step3;

import step3.view.InputView;

public class Main {

  public static void main(String[] args) {
    RaceGame raceGame = new RaceGame();
    InputView inputView = new InputView();

    raceGame.init(inputView.getCarNum(), inputView.getRaceCount());
    raceGame.start();
  }

}
