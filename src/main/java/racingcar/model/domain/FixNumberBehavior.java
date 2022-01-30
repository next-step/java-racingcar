package racingcar.model.domain;

public class FixNumberBehavior implements CarMoveBehavior {

    private static boolean isMove;
    private static FixNumberBehavior fixNumberBehavior;

    static {
        fixNumberBehavior = new FixNumberBehavior(isMove);
    }

    private FixNumberBehavior() {

    }

    public static FixNumberBehavior getInstance(){
        return fixNumberBehavior;
    }

    public FixNumberBehavior(final boolean isMove) {
        this.isMove = isMove;
    }

    @Override
    public boolean moveBehavior() {
        return isMove;
    }
}
