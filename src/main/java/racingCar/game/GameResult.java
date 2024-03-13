package racingCar.game;

import java.util.List;

public class GameResult {
  private List<String> winners;
  private List<String> roundResults;

  public GameResult(List<String> winners, List<String> roundResults){
    this.winners = winners;
    this.roundResults = roundResults;
  }

  public List<String> getWinners() {
    return winners;
  }

  public List<String> getRoundResults() {
    return roundResults;
  }

}
