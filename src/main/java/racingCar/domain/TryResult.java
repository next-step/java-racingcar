package racingCar.domain;

public class TryResult {
  private static final String HYPHEN = "-";

  private final String name;
  private final int position;

  public TryResult(final String name, final int position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return this.name;
  }

  public String getHyphenDistance() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < this.position; i++) {
      sb.append(HYPHEN);
    }
    return sb.toString();
  }
}
