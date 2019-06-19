package racinggame;

import racinggame.model.RacingGame;
import racinggame.model.RacingInfo;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;

public class RacingGameMain {
  public static void main(String[] args) {

    String carName = InputView.inputName();
    int time = InputView.inputTime();

    RacingGame racingGame = new RacingGame(carCount);

    for (int i = 0; i < time; i++) {
      ResultView.resultView(racingGame.startGame());
      System.out.println();
    }
  }
}
