package study.racingcar;

public class Moving {

    private MoveStrategy moveStrategy;

    public boolean isMove(int number) {
        return moveStrategy.isMove(number);
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }
}
