package step3;

public class Car {

    private int position = 0;
    private MoveStrategy moveStrategy;

    public int getPosition() {
        return position;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        position = moveStrategy.move(position);
    }
}
