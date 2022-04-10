package carracing;

public class RacingCar {
    private int position;
    private boolean moved;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public void moveForward() {
        this.position += 1;
        this.moved = true;
    }

    public void stop() {
        this.moved = false;
    }
}
