package racingcar.model.domain;

public class FixNumberBehavior implements CarMoveBehavior{

    private final boolean isMove;

    public FixNumberBehavior(boolean isMove) {
        this.isMove = isMove;
    }

    @Override
    public boolean moveBehavior() {
        return isMove;
    }
}
