package racing.model;

public class RacingGameRequestVO {

  private String names;

  private int totalRound;

  public RacingGameRequestVO() {
  }

  public String getNames() {
    return names;
  }

  public int getTotalRound() {
    return totalRound;
  }

  public void setNames(String names) {
    this.names = names;
  }

  public void setTotalRound(int totalRound) {
    this.totalRound = totalRound;
  }
}
