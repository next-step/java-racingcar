package mission1.step4.algorithm;

public class MoveStrategyCache {

    private MoveStrategyCache(){}

    private static class SingletonHelper{
        private static final MoveStrategy MOVE_STRATEGY_BY_RANDOM_VALUE = new MoveByRandomValue();
    }

    public static MoveStrategy getMoveByRandomValue() {
        return SingletonHelper.MOVE_STRATEGY_BY_RANDOM_VALUE;
    }
}
