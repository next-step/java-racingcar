package carracing;

public class RacingCar {
    private int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void moveForward() {
        this.position += 1;
    }
}
