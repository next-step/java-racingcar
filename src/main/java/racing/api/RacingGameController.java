package racing.api;

import racing.core.RacingCarGame;
import racing.model.RacingGameRequestVO;
import racing.model.RacingGameResponseVO;
import racing.vo.RacingCarGamePlayInfo;

public class RacingGameController {

  private final RacingCarGame racingCarGame;

  public RacingGameController(RacingCarGame racingCarGame) {
    this.racingCarGame = racingCarGame;
  }

  public RacingGameResponseVO play(RacingGameRequestVO requestVO) {
    return new RacingGameResponseVO(racingCarGame.play(RacingCarGamePlayInfo.from(requestVO)));
  }
}
