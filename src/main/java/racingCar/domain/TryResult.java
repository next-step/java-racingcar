package racingCar.domain;

public class TryResult {

  private final String name;
  private final int position;

  public TryResult(final String name, final int position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return this.name;
  }

  public int getPosition() {
    return position;
  }
}
