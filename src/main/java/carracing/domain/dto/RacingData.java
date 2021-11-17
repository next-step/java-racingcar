package carracing.domain.dto;

public class RacingData {

  private final String name;
  private final int step;

  public RacingData(String name, int step) {
    this.name = name;
    this.step = step;
  }

  public int getStep() {
    return step;
  }

  public String getName() {
    return name;
  }
}
