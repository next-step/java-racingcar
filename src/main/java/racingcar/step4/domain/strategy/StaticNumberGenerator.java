package racingcar.step4.domain.strategy;

public class StaticNumberGenerator implements MoveNumberGenerator {

  private final int bound;

  public StaticNumberGenerator(int bound) {
    this.bound = bound;
  }

  public int generate(int bound) {
    return this.bound;
  }
}
