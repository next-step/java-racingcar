package racingGame;

import org.junit.jupiter.api.Test;

public class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMove() {
        return true;
    }
}
