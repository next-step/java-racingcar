package racing.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.core.RacingCarGame;
import racing.model.RacingGameRequestVO;
import racing.model.RacingGameResponseVO;
import racing.rule.OperationMoveRule;
import racing.view.ResultView;

class RacingGameControllerTest {

  private RacingGameController c;

  @BeforeEach
  void setUp() {
    c = new RacingGameController(RacingCarGame.newGame(new OperationMoveRule()));
  }

  @Test
  void play() {
    // given
    RacingGameRequestVO requestVO = new RacingGameRequestVO();
    requestVO.setNames("gmoon, speed, move1, move2");
    requestVO.setTotalRound(3);

    // when
    RacingGameResponseVO responseVO = c.play(requestVO);

    ResultView.print(responseVO.getResponse());
  }

}