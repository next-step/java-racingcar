package racinggame;

public class Car {

    private int position = 1;

    public int position() {
        return this.position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.canMove()) {
            this.position++;
        }
    }
}
