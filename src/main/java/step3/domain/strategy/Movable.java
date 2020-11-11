package step3.domain.strategy;

import step3.domain.Randomize;
import step3.domain.ScoreInspector;

/**
 * Created By mand2 on 2020-11-10.
 */
public class Movable extends MoveStrategy {

    @Override
    public int move() {
        return this.scoreInspector.judgeMovable(this.randomize);
    }

    public Movable(Randomize randomize) {
        super(randomize);
    }
}
