package racingcar.step3.domain.strategy;

@FunctionalInterface
public interface MoveNumberGenerator {
  int generate(int bound);
}