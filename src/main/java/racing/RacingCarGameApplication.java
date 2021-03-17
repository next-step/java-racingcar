package racing;

import racing.core.RacingCarGame;
import racing.domain.RacingRound;
import racing.rule.OperationMoveRule;
import racing.view.InputView;
import racing.view.ResultView;
import racing.vo.RacingCarGamePlayInfo;

import java.util.List;

public class RacingCarGameApplication {

  public static void main(String[] args) {
    RacingCarGamePlayInfo playInfo = InputView.executeConsole();
    List<RacingRound> result = RacingCarGame.newGame(playInfo)
            .setupRule(new OperationMoveRule())
            .play();

    ResultView.print(result);
  }
}
