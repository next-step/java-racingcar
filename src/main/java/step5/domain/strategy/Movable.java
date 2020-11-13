package step5.domain.strategy;

import step5.domain.Randomize;
import step5.domain.ScoreInspector;

/**
 * Created By mand2 on 2020-11-10.
 */
public class Movable implements MoveStrategy {

    private ScoreInspector scoreInspector = new ScoreInspector();

    @Override
    public int move() {
        return scoreInspector.judgeMovable();
    }

}
