package mission1.step4.algorithmForTest;

import mission1.step4.algorithm.MoveStrategy;

public class MoveStrategyStopForTest implements MoveStrategy {
    @Override
    public boolean movable() {
        return false;
    }
}
