package step3.factory;

import step3.domain.GameRule;
import step3.domain.MoveForwardStrategy;
import step3.domain.MoveStopStrategy;
import step3.domain.MoveStrategy;

public class MoveStrategyFactory {

    public static MoveStrategy getInstance(GameRule gameRule) {
        if (gameRule.isMovable()) {
            return new MoveForwardStrategy();
        }

        return new MoveStopStrategy();
    }
}
