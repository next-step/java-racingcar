package racingcar.model.domain;

public class FixMoveBehavior implements CarMoveBehavior {

    private final boolean isMove;

    public FixMoveBehavior(final boolean isMove) {
        this.isMove = isMove;
    }

    @Override
    public boolean moveBehavior() {
        return isMove;
    }
}
