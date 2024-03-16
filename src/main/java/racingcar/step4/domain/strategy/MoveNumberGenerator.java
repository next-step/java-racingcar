package racingcar.step4.domain.strategy;

@FunctionalInterface
public interface MoveNumberGenerator {
  int generate(int bound);
}