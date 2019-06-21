package racinggame;

import racinggame.domain.RacingGame;
import racinggame.domain.RacingInfo;
import racinggame.view.InputView;
import racinggame.view.ResultView;

import java.util.List;

public class RacingGameMain {
  public static void main(String[] args) {

    String carName = InputView.inputName();
    int time = InputView.inputTime();

    RacingGame racingGame = new RacingGame(carName, time);

    List<RacingInfo> result = racingGame.startGame();
    ResultView.resultView(result);
    ResultView.resultWinner(racingGame.getWinner());
  }
}
