package racinggame.domain;

@FunctionalInterface
public interface MoveStrategy {
    boolean moveOrNot();
}