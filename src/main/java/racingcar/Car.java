package racingcar;


public class Car {

    private int position = 0;
    private MoveStrategy moveStrategy;

    public int getPosition() {
        return this.position;
    }

    public Car() {
        this.moveStrategy = new RandomMoveStrategy();
    }

    public boolean isMove() {
        return moveStrategy.isMove();
    }

    public void run(boolean isMove) {
        if (!isMove) {
            return;
        }
        this.position++;
    }

}
