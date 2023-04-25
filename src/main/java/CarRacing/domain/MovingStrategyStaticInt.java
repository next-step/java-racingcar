package CarRacing.domain;

public class MovingStrategyStaticInt implements MovingStrategy {
    @Override
    public int movable(int number) {
        return number;
    }
}
