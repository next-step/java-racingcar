package racingcar.step4.controller.dto;

import racingcar.step4.domain.Winners;

import java.util.List;

public class RacingCarGameWinnerDto {
  private final List<String> winnerNames;

  private RacingCarGameWinnerDto(List<String> winnerNames) {
    this.winnerNames = winnerNames;
  }

  public static RacingCarGameWinnerDto covert(Winners winners) {
    return new RacingCarGameWinnerDto(winners.getWinnerNames());
  }

  public List<String> getWinnerNames() {
    return winnerNames;
  }
}
