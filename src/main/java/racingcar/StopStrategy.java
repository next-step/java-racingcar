package racingcar;

public class StopStrategy implements MoveStrategy {
    private StopStrategy() {}

    public static StopStrategy getInstance() {
        return StopStrategy.SingletonHelper.instance;
    }

    @Override
    public boolean checkMovable() {
        return false;
    }

    private static class SingletonHelper {
        private static final StopStrategy instance = new StopStrategy();
    }
}
