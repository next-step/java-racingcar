package racing;

import racing.core.RacingCarGame;
import racing.domain.RacingRound;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingCarGameApplication {

  public static void main(String[] args) {
    InputView inputView = InputView.executeConsole();
    List<RacingRound> result = RacingCarGame.ready(inputView)
            .play();

    ResultView.print(result);
  }
}
