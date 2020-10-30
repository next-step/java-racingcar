package racinggame.vo;

public class RacingInfo {

  private final int racingCarCount;
  private final int roundCount;

  public RacingInfo(int racingCarCount, int roundCount) {
    this.racingCarCount = racingCarCount;
    this.roundCount = roundCount;
  }

  public int getRacingCarCount() {
    return racingCarCount;
  }

  public int getRoundCount() {
    return roundCount;
  }
}
