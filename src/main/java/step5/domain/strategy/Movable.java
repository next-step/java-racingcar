package step5.domain.strategy;

import step5.domain.Randomize;

/**
 * Created By mand2 on 2020-11-10.
 */
public class Movable implements MoveStrategy {

    @Override
    public int move() {
        return scoreInspector.judgeMovable();
    }

}
