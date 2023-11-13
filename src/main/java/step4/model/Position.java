package step4.model;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public int getCurrentStatus() {
        return this.position;
    }
}
