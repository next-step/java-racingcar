package racingcar.step4.view.dto;

import racingcar.step4.domain.Cars;

import java.util.List;

public class RacingCarGameWinnerDto {
  private final List<String> winnerNames;

  private RacingCarGameWinnerDto(List<String> winnerNames) {
    this.winnerNames = winnerNames;
  }

  public static RacingCarGameWinnerDto covert(Cars winners) {
    return new RacingCarGameWinnerDto(winners.getWinnerNames());
  }

  public List<String> getWinnerNames() {
    return winnerNames;
  }
}
