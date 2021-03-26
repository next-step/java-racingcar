package racing.model;

import racing.domain.RacingRound;

import java.util.List;

public class RacingGameResponseVO {

  private final List<RacingRound> response;

  public RacingGameResponseVO(List<RacingRound> response) {
    this.response = response;
  }

  public List<RacingRound> getResponse() {
    return response;
  }
}
