package racingcar.strategy;

@FunctionalInterface
public interface MovingStrategy {

  boolean decideWhetherToMove();
}
