package racing;

import racing.core.RacingCarGame;
import racing.domain.RacingRound;
import racing.view.InputView;
import racing.view.ResultView;
import racing.vo.RacingCarGamePlayInfo;

import java.util.List;

public class RacingCarGameApplication {

  public static void main(String[] args) {
    RacingCarGamePlayInfo playInfo = InputView.executeConsole();
    List<RacingRound> result = RacingCarGame.newGame(playInfo)
            .play();

    ResultView.print(result);
  }
}
