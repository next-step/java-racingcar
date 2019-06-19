package racinggame.model;

public class RacingInfo {
  private String name;
  private int position;

  public RacingInfo(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }
}
