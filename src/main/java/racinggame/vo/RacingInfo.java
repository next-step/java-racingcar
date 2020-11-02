package racinggame.vo;

public class RacingInfo {

  private final String[] racingCarNames;
  private final int roundCount;

  public RacingInfo(String[] racingCarNames, int roundCount) {
    this.racingCarNames = racingCarNames;
    this.roundCount = roundCount;
  }

  public String[] getRacingCarNames() {
    return racingCarNames;
  }

  public int getRoundCount() {
    return roundCount;
  }
}
