package racing.domain.strategy;

@FunctionalInterface
public interface MoveStrategy {

    boolean shouldMove();
}
