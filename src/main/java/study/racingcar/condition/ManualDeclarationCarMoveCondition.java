package study.racingcar.condition;

/**
 * Created by wyparks2@gmail.com on 2019-06-18
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ManualDeclarationCarMoveCondition implements CarMoveCondition {
    private boolean canMove;

    public ManualDeclarationCarMoveCondition(boolean canMove) {
        this.canMove = canMove;
    }

    @Override
    public boolean canMove() {
        return this.canMove;
    }
}
