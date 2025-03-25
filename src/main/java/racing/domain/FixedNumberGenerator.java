package racing.domain;

public class FixedNumberGenerator implements NumberGenerator {

  private final int fixedNumber;

  public FixedNumberGenerator(int fixedNumber) {
    this.fixedNumber = fixedNumber;
  }

  @Override
  public int generate() {
    return fixedNumber;
  }
}
