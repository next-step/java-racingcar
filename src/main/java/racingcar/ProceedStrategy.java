package racingcar;

public class ProceedStrategy implements MoveStrategy {
    private ProceedStrategy() {}

    public static ProceedStrategy getInstance() {
        return ProceedStrategy.SingletonHelper.instance;
    }

    @Override
    public boolean checkMovable() {
        return true;
    }

    private static class SingletonHelper {
        private static final ProceedStrategy instance = new ProceedStrategy();
    }
}
