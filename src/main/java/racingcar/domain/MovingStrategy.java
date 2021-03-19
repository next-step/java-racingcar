package racingcar.domain;

@FunctionalInterface
public interface MovingStrategy {
  boolean moveable(int generatedRandomNumber);
}
