package domain;

public class RacingCar {
    private int position;

    private RacingCar() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }
}
