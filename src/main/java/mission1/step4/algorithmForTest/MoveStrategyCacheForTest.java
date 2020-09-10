package mission1.step4.algorithmForTest;

import mission1.step4.algorithm.MoveByRandomValue;
import mission1.step4.algorithm.MoveStrategy;
import mission1.step4.algorithm.MoveStrategyCache;

public class MoveStrategyCacheForTest {

    private static final int PROGRESS_CONDITION = 4;

    private MoveStrategyCacheForTest(){}

    private static class SingletonHelper{
        private static final MoveStrategy MOVE_STRATEGY_PROGRESS_FOR_TEST = new MoveStrategyProgressForTest();
        private static final MoveStrategy MOVE_STRATEGY_STOP_FOR_TEST = new MoveStrategyStopForTest();
    }

    public static MoveStrategy getMoveByRandomValue(int randomValue) {
        if (randomValue >= PROGRESS_CONDITION) {
            return SingletonHelper.MOVE_STRATEGY_PROGRESS_FOR_TEST;
        }

        return SingletonHelper.MOVE_STRATEGY_STOP_FOR_TEST;
    }

}
