package racing.api;

import racing.core.RacingCarGame;
import racing.domain.RacingRound;
import racing.view.InputView;
import racing.view.ResultView;
import racing.vo.RacingCarGamePlayInfo;

import java.util.List;

public class RacingGameController {
  private final RacingCarGame racingCarGame;

  public RacingGameController(RacingCarGame racingCarGame) {
    this.racingCarGame = racingCarGame;
  }

  public void play() {
    RacingCarGamePlayInfo playInfo = InputView.executeConsole();
    List<RacingRound> result = racingCarGame.play(playInfo);
    ResultView.print(result);
  }
}
