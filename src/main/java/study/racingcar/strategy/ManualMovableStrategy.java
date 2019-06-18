package study.racingcar.strategy;

/**
 * Created by wyparks2@gmail.com on 2019-06-18
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ManualMovableStrategy implements MovableStrategy {
    private boolean canMove;

    public ManualMovableStrategy(boolean canMove) {
        this.canMove = canMove;
    }

    @Override
    public boolean canMove() {
        return this.canMove;
    }
}
