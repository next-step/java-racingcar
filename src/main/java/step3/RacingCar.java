package step3;

public class RacingCar {

    private int position;

    public RacingCar() {
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.moveCurrentPosition();
        }
    }

    private void moveCurrentPosition() {
        this.position += 1;
    }

    public int getPosition() {
        return this.position;
    }
}
